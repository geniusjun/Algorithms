import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, ret;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] maps;
    static Set<Character> visitMap;

    static void go(int idx, int y, int x) {
        ret = Integer.max(ret, idx);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                continue;
            }
            if (visitMap.contains(maps[ny][nx])) {
                continue;
            }
            visitMap.add(maps[ny][nx]);
            go(idx + 1, ny, nx);
            visitMap.remove(maps[ny][nx]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        maps = new char[Y][X];
        visitMap = new HashSet<>();

        for (int i = 0; i < Y; i++) {
            String input = bf.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = input.charAt(j);
            }
        }

        ret = Integer.MIN_VALUE;
        visitMap.add(maps[0][0]);
        go(1, 0, 0);

        System.out.println(ret);

    }
}