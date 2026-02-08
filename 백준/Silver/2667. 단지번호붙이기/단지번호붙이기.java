
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] maps;
    static int[][] visited;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int DFS(int y, int x) {
        int amount = 1;
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || maps[ny][nx] == 0
                    || visited[ny][nx] == 1) {
                continue;
            }
            if (maps[ny][nx] == 1) {
                amount += DFS(ny, nx);
            }
        }
        return amount;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        maps = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(line[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && visited[i][j] == 0) {
                    list.add(DFS(i, j));
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}