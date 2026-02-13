import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean isUnite;
    static int ret;
    static List<Node> unites;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void go(int y, int x) {
        visited[y][x] = 1;
        unites.add(new Node(y, x));
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] == 1) {
                continue;
            }
            int gap = Math.abs(maps[y][x] - maps[ny][nx]);
            if ((gap >= L && gap <= R) && visited[ny][nx] == 0) {
                go(ny, nx);
                isUnite = true;
            }
        }
    }

    static void move() {
        int sum = 0;
        for (int i = 0; i < unites.size(); i++) {
            sum += maps[unites.get(i).y][unites.get(i).x];
        }

        for (int i = 0; i < unites.size(); i++) {
            maps[unites.get(i).y][unites.get(i).x] = sum / unites.size();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        while (true) {
            visited = new int[N][N];
            isUnite = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        unites = new ArrayList<>();
                        go(i, j);
                    }
                    if (unites.size() > 1) {
                        move();
                    }
                }
            }

            if (!isUnite) {
                break;
            } else {
                ret++;
            }
        }

        System.out.println(ret);
    }
}