import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int area;

    static void dfs(int y, int x) {
        visited[y][x] = 1;
        area++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || visited[ny][nx] == 1) {
                continue;
            }
            if (maps[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < K; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            int startY = Integer.parseInt(line.nextToken());
            int startX = Integer.parseInt(line.nextToken());
            int endY = Integer.parseInt(line.nextToken());
            int endX = Integer.parseInt(line.nextToken());
            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    maps[j][k] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && maps[i][j] == 0) {
                    area = 0;
                    dfs(i, j);
                    list.add(area);
                    ret++;
                }
            }
        }
        System.out.println(ret);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}