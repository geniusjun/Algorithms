import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

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

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];
        visited = new int[Y][X];
        List<Node> startPoint = new ArrayList<>();
        boolean isDone = true;

        for (int i = 0; i < Y; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                int value = Integer.parseInt(line.nextToken());
                if (value == 1) {
                    startPoint.add(new Node(i, j));
                }
                if (value == 0) {
                    isDone = false;
                }
                maps[i][j] = value;
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < startPoint.size(); i++) {
            queue.add(new Node(startPoint.get(i).y, startPoint.get(i).x));
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node[] frontNodes = new Node[size];
            for (int i = 0; i < size; i++) {
                frontNodes[i] = queue.poll();
            }
            for (int k = 0; k < size; k++) {
                for (int j = 0; j < 4; j++) {
                    int ny = frontNodes[k].y + dy[j];
                    int nx = frontNodes[k].x + dx[j];

                    if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] == 1 || maps[ny][nx] == -1) {
                        continue;
                    }

                    if (maps[ny][nx] == 0) {
                        maps[ny][nx] = 1;
                        visited[ny][nx] = visited[frontNodes[k].y][frontNodes[k].x] + 1;
                        queue.add(new Node(ny, nx));
                    }
                }
            }
        }
        boolean isImpossible = false;
        int ret = Integer.MIN_VALUE;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (maps[i][j] == 0) {
                    isImpossible = true;
                }
                ret = Math.max(ret, visited[i][j]);
            }
        }
        if (isDone) {
            System.out.println(0);
        } else if (isImpossible) {
            System.out.println(-1);
        } else {
            System.out.println(ret);
        }

    }

}