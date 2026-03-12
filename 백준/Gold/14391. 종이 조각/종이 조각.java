import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, ret;
    static int[][] maps;
    static int[][] type; // 가로 0, 세로 1

    static void dfs(int idx) {
        if (idx == Y * X) {
            calc();
            return;
        }

        int y = idx / X;
        int x = idx % X;  // 이 아이디어 좋다,,,

        type[y][x] = 0; // 가로 선택
        dfs(idx + 1);

        type[y][x] = 1; // 세로 선택
        dfs(idx + 1);
    }

    static void calc() {
        int sum = 0;

        // 가로 세기
        for (int i = 0; i < Y; i++) {
            int cur = 0;
            for (int j = 0; j < X; j++) {
                if (type[i][j] != 0) {
                    cur = cur * 10 + maps[i][j];
                } else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        // 새로 세기
        for (int j = 0; j < X; j++) {
            int cur = 0;
            for (int i = 0; i < Y; i++) {
                if (type[i][j] != 1) {
                    cur = cur * 10 + maps[i][j];
                } else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }

        ret = Math.max(ret, sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        maps = new int[Y][X];
        type = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            String input = bf.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = input.charAt(j) - '0';
            }
        }

        ret = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(ret);

    }
}