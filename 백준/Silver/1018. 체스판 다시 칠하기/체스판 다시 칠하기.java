import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, ret;
    static char[][] maps;

    static int countRepaint(int sy, int sx) {
        int white = 0;
        int black = 0;

        for (int i = sy; i < sy + 8; i++) {
            for (int j = sx; j < sx + 8; j++) {
                // 짝수 칸
                if ((i + j) % 2 == 0) {
                    if (maps[i][j] != 'W') {
                        white++;
                    }
                    if (maps[i][j] != 'B') {
                        black++;
                    }
                } else { // 홀수 칸 시작 색과 반대여야함.
                    if (maps[i][j] != 'B') {
                        white++;
                    }
                    if (maps[i][j] != 'W') {
                        black++;
                    }
                }
            }
        }

        return Math.min(white, black);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        maps = new char[Y][X];
        for (int i = 0; i < Y; i++) {
            String input = br.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = input.charAt(j);
            }
        }
        ret = Integer.MAX_VALUE;
        for (int i = 0; i <= Y - 8; i++) {
            for (int j = 0; j <= X - 8; j++) {
                ret = Math.min(ret, countRepaint(i, j));
            }
        }

        System.out.println(ret);
    }
}