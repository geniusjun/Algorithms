import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || visited[ny][nx] == 1) {
                continue;
            }
            if (maps[ny][nx] == 1) {
                dfs(ny, nx);
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int cabbageCnt = Integer.parseInt(st.nextToken());
            maps = new int[Y][X];
            visited = new int[Y][X];

            for (int i = 0; i < cabbageCnt; i++) {
                StringTokenizer line = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(line.nextToken());
                int y = Integer.parseInt(line.nextToken());
                maps[y][x] = 1;
            }
            int ret = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (maps[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j);
                        ret++;
                    }
                }
            }

            System.out.println(ret);
        }
    }
}