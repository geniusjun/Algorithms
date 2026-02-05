import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] maps;
    static int[][] visited;

    static void DFS(int y, int x) {
        int nx = x + 1;
        if (nx >= maps[0].length || maps[y][nx] == 0) {
            return;
        }
        visited[y][nx] = visited[y][x] + 1;
        DFS(y, nx);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        maps = new int[H][W];
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < W; j++) {
                if (line[j].equals("c")) {
                    maps[i][j] = 0;
                    visited[i][j] = 0;
                } else { // .
                    maps[i][j] = -1;
                    visited[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (maps[i][j] == 0) {
                    DFS(i, j);
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }
}