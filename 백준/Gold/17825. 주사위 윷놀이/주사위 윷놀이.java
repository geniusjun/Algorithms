import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dice = new int[10];
    static int[] score = new int[33]; // 각 칸의 점수
    static int[] next = new int[33]; // 빨간 화살표 기준 다음 칸
    static int[] blue = new int[33]; // 파란 화살표 기준 다음 칸
    static int ret = 0;
    static final int FINISH = 32;

    static void init() {
        // 시작, 도착 점수 세팅
        score[0] = 0;
        score[FINISH] = 0;

        // 바깥길 점수 세팅
        for (int i = 1; i <= 20; i++) {
            score[i] = i * 2;
        }

        // 바깥길 다음길 세팅
        for (int i = 0; i < 20; i++) {
            next[i] = i + 1;
        }
        next[20] = FINISH; // 20 다음은 FINISH

        // 10에서 파란길 점수 및 next 세팅 10 -> 13 -> 16 -> 19 -> 25
        score[21] = 13;
        score[22] = 16;
        score[23] = 19;
        blue[5] = 21; // 파란색 화살표 10 -> 13
        next[21] = 22;
        next[22] = 23;
        next[23] = 29; // 19 -> 25

        // 20에서 파란길 점수 및 next 세팅 20 -> 22 -> 24 -> 25
        score[24] = 22;
        score[25] = 24;
        blue[10] = 24; // 파란색 화살표 20 -> 22;
        next[24] = 25;
        next[25] = 29;

        // 30에서 파란길 점수 및 next 세팅 30 -> 28 -> 27 -> 26 -> 25
        score[26] = 28;
        score[27] = 27;
        score[28] = 26;
        blue[15] = 26; // 파란색 화살표 30 -> 28
        next[26] = 27;
        next[27] = 28;
        next[28] = 29;

        // 공통길 세팅 25 -> 30 -> 35 -> 40
        score[29] = 25;
        score[30] = 30;
        score[31] = 35;
        next[29] = 30;
        next[30] = 31;
        next[31] = 20; // 35 -> 40

    }

    static int move(int start, int dist) {
        if (blue[start] != 0) { // 10, 20, 30 위에서 시작이라면 처음에 안쪽으로 한번 가기!
            start = blue[start];
            dist--;
        } else {
            start = next[start];
            dist--;
        }

        if (start == FINISH) {
            return FINISH;
        }

        while (dist > 0 && start != FINISH) {
            dist--;
            start = next[start];
        }
        return start;
    }

    static void dfs(int turn, int[] horse, int sum) {
        if (turn == 10) {
            ret = Math.max(sum, ret);
            return;
        }

        int dist = dice[turn];

        for (int i = 0; i < 4; i++) {
            int cur = horse[i];
            if (cur == FINISH) { // 도착한 말은 안움직임
                continue;
            }
            int nxt = move(horse[i], dist);

            if (nxt != FINISH) {
                boolean isThere = false;
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (horse[j] == nxt) {
                        isThere = true;
                        break;
                    }
                }
                if (isThere) { // 이미 그곳에 말이 있으면 전진 노노
                    continue;
                }
            }

            horse[i] = nxt;
            dfs(turn + 1, horse, sum + score[nxt]);
            horse[i] = cur; // 원복

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init();

        int[] horse = new int[4];
        dfs(0, horse, 0);

        System.out.println(ret);
    }

}
