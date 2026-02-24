import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;
    static int[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void go(int cnt, int cost) {

        if (cnt == 3) {
            ret = Math.min(cost, ret);
            return;
        }
        if (cost > ret) { // 가지치기
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (canFlower(i, j)) {
                    go(cnt + 1, cost + makeFlower(i, j));
                    eraseFlower(i, j);
                }
            }
        }

    }

    static boolean canFlower(int y, int x) {
        if (visited[y][x] != 0) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                return false;
            }
            if (visited[ny][nx] != 0) {
                return false;
            }
        }
        return true;
    }

    static int makeFlower(int y, int x) {
        int sum = maps[y][x];
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                continue;
            }
            visited[ny][nx] = 1;
            sum += maps[ny][nx];
        }
        return sum;
    }

    static void eraseFlower(int y, int x) {
        visited[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                continue;
            }
            visited[ny][nx] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        maps = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ret = Integer.MAX_VALUE;
        go(0, 0);

        System.out.println(ret);
    }
}