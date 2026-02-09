import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] maps;
    static int[][] visited;
    static int ret;

    static void DFS(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || visited[ny][nx] == 1) {
                continue;
            }

            if (maps[ny][nx] == 1) {
                maps[ny][nx] = 0;
                visited[ny][nx] = 1;
                ret++;
            } else if (maps[ny][nx] == 0) {
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                maps[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        int cnt = 0;
        boolean isCheese = true;
        while (isCheese) {
            visited = new int[Y][X];
            ret = 0;
            DFS(0, 0);
            cnt++;
            isCheese = false;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (maps[i][j] == 1) {
                        isCheese = true;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(ret);
    }

}