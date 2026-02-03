import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[][] maps;

    static void quad(int y, int x, int size, StringBuilder sb) {
        if (size == 1) {
            sb.append(maps[y][x]);
            return;
        }
        String now = maps[y][x];
        boolean same = true;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (!now.equals(maps[i][j])) {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            sb.append(now);
            return;
        }

        sb.append("(");
        quad(y, x, size / 2, sb);
        quad(y, x + size / 2, size / 2, sb);
        quad(y + size / 2, x, size / 2, sb);
        quad(y + size / 2, x + size / 2, size / 2, sb);
        sb.append(")");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        maps = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                maps[i][j] = line[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        quad(0, 0, N, sb);
        System.out.println(sb);
    }
}