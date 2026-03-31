import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int ret = Integer.MAX_VALUE;
    static int[][] origin;
    static Rotation[] ops;
    static Rotation[] selected;
    static boolean[] visited;

    static class Rotation {
        int r, c, s;

        Rotation(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void perm(int idx) {
        if (idx == K) {
            int[][] copy = copyMap(origin);

            for (int i = 0; i < K; i++) {
                rotate(copy, selected[i]);
            }

            ret = Math.min(ret, getMin(copy));

            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selected[idx] = ops[i];
            perm(idx + 1);
            visited[i] = false;
        }
    }

    static void rotate(int[][] map, Rotation op) {
        int r = op.r;
        int c = op.c;
        int s = op.s;

        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int left = c - layer;
            int bottom = r + layer;
            int right = c + layer;

            List<Point> positions = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            // 위쪽: 좌 -> 우
            for (int i = left; i < right; i++) {
                positions.add(new Point(top, i));
            }
            // 오른쪽 : 상 -> 하
            for (int i = top; i < bottom; i++) {
                positions.add(new Point(i, right));
            }
            // 아래 : 우 -> 좌
            for (int i = right; i > left; i--) {
                positions.add(new Point(bottom, i));
            }
            // 왼쪽 : 하 -> 상
            for (int i = bottom; i > top; i--) {
                positions.add(new Point(i, left));
            }

            for (Point p : positions) {
                values.add(map[p.y][p.x]);
            }

            int last = values.get(values.size() - 1);
            for (int i = values.size() - 1; i > 0; i--) {
                values.set(i, values.get(i - 1));
            }
            values.set(0, last);

            for (int i = 0; i < positions.size(); i++) {
                Point p = positions.get(i);
                map[p.y][p.x] = values.get(i);
            }
        }
    }

    static int getMin(int[][] map) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        origin = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ops = new Rotation[K];
        selected = new Rotation[K];
        visited = new boolean[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            ops[i] = new Rotation(r, c, s);
        }

        perm(0);
        System.out.println(ret);
    }
}