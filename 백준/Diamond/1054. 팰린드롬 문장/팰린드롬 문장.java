import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] w, rw;
    static char[][] ch, rch;
    static int[] len;
    static long MOD = Long.MAX_VALUE; // 모듈로 없음, 그냥 long 사용
    static HashMap<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        w = new String[N];
        rw = new String[N];
        ch = new char[N][];
        rch = new char[N][];
        len = new int[N];

        for (int i = 0; i < N; i++) {
            w[i] = br.readLine().trim();
            rw[i] = new StringBuilder(w[i]).reverse().toString();
            ch[i] = w[i].toCharArray();
            rch[i] = rw[i].toCharArray();
            len[i] = w[i].length();
        }

        long ans = 0;
        // 시작: 빈 상태에서 '오른쪽에' 단어 i 하나를 올려두고 시작 (미매칭 = w[i][0..])
        for (int i = 0; i < N; i++) {
            int mask = 1 << i;
            ans += dfs(mask, i, 0, 0);
        }

        System.out.println(ans);
    }

    // 상태를 long 키로 압축
    static long key(int mask, int i, int pos, int dir) {
        // mask(13비트) | i(4비트) | pos(4비트) | dir(1비트)
        // 최대 pos는 단어 길이<=13 이므로 4비트면 충분
        long k = mask;
        k = (k << 4) | i;
        k = (k << 4) | pos;
        k = (k << 1) | dir;
        return k;
    }

    static long dfs(int mask, int i, int pos, int dir) {
        long k = key(mask, i, pos, dir);
        Long cached = memo.get(k);
        if (cached != null) return cached;

        long res = 0;

        // 1) 현재 미매칭 조각 자체가 팰린드롬이면, 여기서 종료 가능 (문장 하나 완성)
        if (isUnmatchedPalindrome(i, pos, dir)) {
            res += 1;
        }

        // 2) 새 단어를 붙여 계속 확장
        for (int j = 0; j < N; j++) {
            if ((mask & (1 << j)) != 0) continue; // 이미 사용됨

            if (dir == 0) {
                // 미매칭: words[i][pos..], 왼쪽에 단어 j를 붙임 => rev[j]와 매칭
                int common = lcpWordsVsRev(i, pos, j);
                int remA = len[i] - pos;
                int remB = len[j]; // rev[j]의 길이 = len[j]

                if (common == remA && common == remB) {
                    // 둘 다 소진 => 균형 상태
                    int mask2 = mask | (1 << j);
                    // 균형에서 즉시 종료 가능 (문장 하나)
                    res += 1;
                    // 균형에서 계속 이어가고 싶으면, 남은 단어들 중 하나를 새 미매칭 시작으로
                    for (int k2 = 0; k2 < N; k2++) {
                        if ((mask2 & (1 << k2)) == 0) {
                            res += dfs(mask2 | (1 << k2), k2, 0, 0);
                        }
                    }
                } else if (common == remA && common < remB) {
                    // 오른쪽 조각 소진, 왼쪽 rev[j]가 더 김 => 새 미매칭은 rev[j][common..] (dir=1)
                    res += dfs(mask | (1 << j), j, common, 1);
                } else if (common < remA && common == remB) {
                    // 왼쪽 rev[j] 소진, 오른쪽 words[i]가 남음 => 같은 단어 i에서 pos 전진 (dir=0 유지)
                    res += dfs(mask | (1 << j), i, pos + common, 0);
                }
                // 둘 다 남는데 다음 문자가 달라서 더 못 맞추면(=common < remA && common < remB) 전이 불가
            } else {
                // dir == 1
                // 미매칭: rev[i][pos..], 오른쪽에 단어 j를 붙임 => words[j]와 매칭
                int common = lcpRevVsWords(i, pos, j);
                int remA = len[i] - pos; // rev[i] 남은 길이
                int remB = len[j];

                if (common == remA && common == remB) {
                    int mask2 = mask | (1 << j);
                    res += 1; // 균형에서 종료
                    for (int k2 = 0; k2 < N; k2++) {
                        if ((mask2 & (1 << k2)) == 0) {
                            res += dfs(mask2 | (1 << k2), k2, 0, 0);
                        }
                    }
                } else if (common == remA && common < remB) {
                    // 왼쪽 rev[i] 소진, 오른쪽 words[j]가 남음 => 새 미매칭은 words[j][common..] (dir=0)
                    res += dfs(mask | (1 << j), j, common, 0);
                } else if (common < remA && common == remB) {
                    // 오른쪽 words[j] 소진, 왼쪽 rev[i]가 남음 => pos 전진 (dir=1 유지)
                    res += dfs(mask | (1 << j), i, pos + common, 1);
                }
            }
        }

        memo.put(k, res);
        return res;
    }

    // words[i][pos..] 와 rev[j][0..]의 LCP 길이
    static int lcpWordsVsRev(int i, int pos, int j) {
        char[] A = ch[i];
        char[] B = rch[j];
        int ai = pos, bi = 0, cnt = 0;
        while (ai < A.length && bi < B.length && A[ai] == B[bi]) {
            ai++; bi++; cnt++;
        }
        return cnt;
    }

    // rev[i][pos..] 와 words[j][0..]의 LCP 길이
    static int lcpRevVsWords(int i, int pos, int j) {
        char[] A = rch[i];
        char[] B = ch[j];
        int ai = pos, bi = 0, cnt = 0;
        while (ai < A.length && bi < B.length && A[ai] == B[bi]) {
            ai++; bi++; cnt++;
        }
        return cnt;
    }

    // 현재 미매칭 조각이 팰린드롬인지 검사
    // dir=0: words[i][pos..end]
    // dir=1: rev[i][pos..end]
    static boolean isUnmatchedPalindrome(int i, int pos, int dir) {
        char[] A = (dir == 0) ? ch[i] : rch[i];
        int l = pos, r = A.length - 1;
        while (l < r) {
            if (A[l] != A[r]) return false;
            l++; r--;
        }
        return true;
    }
}
