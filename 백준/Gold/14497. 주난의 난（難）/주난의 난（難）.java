import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        StringTokenizer line = new StringTokenizer(bf.readLine());

        maps = new int[Y][X];
        visited = new int[Y][X];

        int jY = Integer.parseInt(line.nextToken()) - 1;
        int jX = Integer.parseInt(line.nextToken()) - 1;
        int cY = Integer.parseInt(line.nextToken()) - 1;
        int cX = Integer.parseInt(line.nextToken()) - 1;

        if (jY == cY && jX == cX) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < Y; i++) {
            String input = bf.readLine();
            for (int j = 0; j < X; j++) {
                if (i == jY && j == jX) {
                    maps[i][j] = -1; // 주난
                    continue;
                }
                if (i == cY && j == cX) {
                    maps[i][j] = -1; // 초코바
                    continue;
                }
                maps[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addFirst(new Node(jY, jX));
        visited[jY][jX] = 1;
        while (!queue.isEmpty()) {
            Node front = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                    continue;
                }

                int w = maps[ny][nx] == 1 ? 1 : 0;
                int newCost = visited[front.y][front.x] + w;

                if (visited[ny][nx] == 0 || newCost < visited[ny][nx]) {
                    visited[ny][nx] = newCost;
                    if (w == 0) {
                        queue.addFirst(new Node(ny, nx));
                    } else {
                        queue.addLast(new Node(ny, nx));
                    }
                }
            }
        }
        System.out.println(visited[cY][cX]);


    }
}