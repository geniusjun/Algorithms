import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Y, X, K, ret;
    static char[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void go(int idx, Node here) {
        if (idx == K && here.y == 0 && here.x == X - 1) {
            ret++;
            return;
        }
        if (idx > K) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = here.y + dy[i];
            int nx = here.x + dx[i];
            if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0 || maps[ny][nx] == 'T') {
                continue;
            }
            visited[ny][nx] = 1;
            go(idx + 1, new Node(ny, nx));
            visited[ny][nx] = 0;
        }

    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        maps = new char[Y][K];
        visited = new int[Y][K];

        for (int i = 0; i < Y; i++) {
            String line = bf.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = line.charAt(j);
            }
        }
        ret = 0;
        visited[Y - 1][0] = 1;
        go(1, new Node(Y - 1, 0));

        System.out.println(ret);
    }
}