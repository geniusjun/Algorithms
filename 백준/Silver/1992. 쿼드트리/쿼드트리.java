import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[][] maps;

    static String quad(int y, int x, int size) {
        if (size == 1) {
            return maps[y][x];
        }
        String now = maps[y][x];
        String ret = "";
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (!now.equals(maps[i][j])) {
                    ret += "(";
                    ret += quad(y, x, size / 2);
                    ret += quad(y, x + size / 2, size / 2);
                    ret += quad(y + size / 2, x, size / 2);
                    ret += quad(y + size / 2, x + size / 2, size / 2);
                    ret += ")";
                    return ret;
                }
            }
        }

        return maps[y][x];
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

        System.out.println(quad(0, 0, N));
    }
}