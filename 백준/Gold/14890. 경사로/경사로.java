import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L, ret;
    static int[][] maps;

    static boolean checkLine(int[] line) {
        boolean[] used = new boolean[N]; // 체크하려는 길 안에서 경사로로 사용한 길인지

        for (int i = 0; i < N - 1; i++) {
            int cur = line[i];
            int nxt = line[i + 1];

            if (cur == nxt) {
                continue;
            }
            if (Math.abs(cur - nxt) > 1) {
                return false;
            }

            // 내리막: cur -> nxt(cur = nxt + 1), nxt부터 L칸이 모두 nxt여야 경사로 가능
            if (cur == nxt + 1) {
                for (int k = i + 1; k <= i + L; k++) { // 내리막은 앞으로 진행
                    if (k >= N) {
                        return false; // 범위 넘으면 경사로 x
                    }
                    if (line[k] != nxt) { // 높이가 일정하지 않으면 경사로 X
                        return false;
                    }
                    if (used[k]) { // 사용한 곳이면 경사로 x
                        return false;
                    }
                    used[k] = true;
                }
            } else if (cur + 1 == nxt) {
                for (int k = i; k >= i - L + 1; k--) {
                    if (k < 0) { // 범위
                        return false;
                    }
                    if (line[k] != cur) {
                        return false;
                    }
                    if (used[k]) {
                        return false;
                    }
                    used[k] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        ret = 0;

        // 가로
        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            for (int j = 0; j < N; j++) {
                line[j] = maps[i][j];
            }
            if (checkLine(line)) {
                ret++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            for (int j = 0; j < N; j++) {
                line[j] = maps[j][i];
            }
            if (checkLine(line)) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}