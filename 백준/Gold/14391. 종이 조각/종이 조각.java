import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, ret;
    static int[][] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        maps = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            String input = bf.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = input.charAt(j) - '0';
            }
        }
        ret = 0;

        for (int s = 0; s < (1 << Y * X); s++) {
            int sum = 0;
            // 가로 계산
            for (int i = 0; i < Y; i++) {
                int cur = 0;
                for (int j = 0; j < X; j++) {
                    int k = i * X + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + maps[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            // 새로 계산
            for (int j = 0; j < X; j++) {
                int cur = 0;
                for (int i = 0; i < Y; i++) {
                    int k = i * X + j;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + maps[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ret = Math.max(sum, ret);
        }

        System.out.println(ret);

    }
}