import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x, int water) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || visited[ny][nx] == 1) {
                continue;
            }
            if (maps[ny][nx] > water) {
                dfs(ny, nx, water);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        maps = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                max = Math.max(max, height);
                maps[i][j] = height;
            }
        }
        int water = 0;
        int ret = 0;
        while (water <= max) {
            visited = new int[N][N];
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (maps[i][j] > water && visited[i][j] == 0) {
                        dfs(i, j, water);
                        safe++;
                    }
                }
            }
            ret = Math.max(ret, safe);
            water++;
        }
        System.out.println(ret);
    }
}