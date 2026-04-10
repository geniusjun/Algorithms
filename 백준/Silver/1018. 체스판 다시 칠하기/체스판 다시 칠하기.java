import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 8x8 시작점 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, countRepaint(i, j));
            }
        }

        System.out.println(answer);
    }

    static int countRepaint(int sy, int sx) {
        int whiteStart = 0; // 왼쪽 위가 W라고 가정
        int blackStart = 0; // 왼쪽 위가 B라고 가정

        for (int i = sy; i < sy + 8; i++) {
            for (int j = sx; j < sx + 8; j++) {
                // (i + j) 짝수칸: 시작색과 같은 색이어야 함
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') {
                        whiteStart++;
                    }
                    if (board[i][j] != 'B') {
                        blackStart++;
                    }
                } else { // 홀수칸: 시작색과 반대색이어야 함
                    if (board[i][j] != 'B') {
                        whiteStart++;
                    }
                    if (board[i][j] != 'W') {
                        blackStart++;
                    }
                }
            }
        }

        return Math.min(whiteStart, blackStart);
    }
}