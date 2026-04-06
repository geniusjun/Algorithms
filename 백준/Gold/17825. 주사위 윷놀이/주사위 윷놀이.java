import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int FINISH = 32;

    static int[] dice = new int[10];
    static int[] score = new int[33]; // 각 칸의 점수
    static int[] next = new int[33];  // 빨간 화살표 기준 다음 칸
    static int[] blue = new int[33];  // 파란 화살표 시작 칸이면 그 다음 칸
    static int answer = 0;

    static void initBoard() {
        // 0 : 시작
        // 1 ~ 20 : 바깥길 (2,4,6,...,40)
        // 21 ~ 23 : 10에서 파란길 (13,16,19)
        // 24 ~ 25 : 20에서 파란길 (22,24)
        // 26 ~ 28 : 30에서 파란길 (28,27,26)
        // 29 ~ 31 : 공통길 (25,30,35)
        // 32 : 도착

        // 시작, 도착
        score[0] = 0;
        score[FINISH] = 0;

        // 바깥길 점수 세팅
        for (int i = 1; i <= 20; i++) {
            score[i] = i * 2; // 2,4,6,...,40
        }

        // 바깥길 next
        for (int i = 0; i < 20; i++) {
            next[i] = i + 1;
        }
        next[20] = FINISH; // 40 다음은 도착

        // 10에서 파란길: 13 -> 16 -> 19 -> 25
        score[21] = 13;
        score[22] = 16;
        score[23] = 19;
        next[21] = 22;
        next[22] = 23;
        next[23] = 29;

        // 20에서 파란길: 22 -> 24 -> 25
        score[24] = 22;
        score[25] = 24;
        next[24] = 25;
        next[25] = 29;

        // 30에서 파란길: 28 -> 27 -> 26 -> 25
        score[26] = 28;
        score[27] = 27;
        score[28] = 26;
        next[26] = 27;
        next[27] = 28;
        next[28] = 29;

        // 공통길: 25 -> 30 -> 35 -> 40 -> 도착
        score[29] = 25;
        score[30] = 30;
        score[31] = 35;
        next[29] = 30;
        next[30] = 31;
        next[31] = 20; // 공통길의 35 다음은 바깥길의 40(노드 20)

        // 파란 화살표
        blue[5] = 21;   // 바깥길 10에서 출발하면 13으로
        blue[10] = 24;  // 바깥길 20에서 출발하면 22로
        blue[15] = 26;  // 바깥길 30에서 출발하면 28로
    }

    static int move(int start, int dist) {
        if (start == FINISH) {
            return FINISH;
        }

        int cur = start;

        // 첫 한 칸만 파란 화살표 가능
        if (blue[cur] != 0) {
            cur = blue[cur];
            dist--;
        } else {
            cur = next[cur];
            dist--;
        }

        // 나머지는 빨간 화살표만 따라감
        while (dist > 0 && cur != FINISH) {
            cur = next[cur];
            dist--;
        }

        return cur;
    }

    static void dfs(int turn, int[] horse, int sum) {
        if (turn == 10) {
            answer = Math.max(answer, sum);
            return;
        }

        int dist = dice[turn];

        for (int i = 0; i < 4; i++) {
            int cur = horse[i];

            // 이미 도착한 말은 못 움직임
            if (cur == FINISH) {
                continue;
            }

            int nxt = move(cur, dist);

            // 도착 칸이 아니면 다른 말과 겹치면 안 됨
            if (nxt != FINISH) {
                boolean conflict = false;
                for (int j = 0; j < 4; j++) {
                    if (i == j) continue;
                    if (horse[j] == nxt) {
                        conflict = true;
                        break;
                    }
                }
                if (conflict) continue;
            }

            horse[i] = nxt;
            dfs(turn + 1, horse, sum + score[nxt]);
            horse[i] = cur; // 백트래킹
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        initBoard();

        int[] horse = new int[4]; // 말 4개 모두 시작 칸(0)
        dfs(0, horse, 0);

        System.out.println(answer);
    }
}