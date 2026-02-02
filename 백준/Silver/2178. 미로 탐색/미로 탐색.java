import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maps;
    static int[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

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
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];
        visited = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < X; j++) {
                maps[i][j] = Integer.parseInt(line[j]);
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                    continue;
                }
                if (visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    visited[ny][nx] = visited[front.y][front.x] + 1;
                    queue.add(new Node(ny, nx));
                }
            }
        }

        System.out.println(visited[Y - 1][X - 1]);

    }
}