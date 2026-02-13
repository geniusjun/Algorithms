import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int Y;
    static int X;
    static String[][] maps;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Node> lands;
    static int max;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void BFS(Node startNode) {
        visited[startNode.y][startNode.x] = 1;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] == 1) {
                    continue;
                }
                if (visited[ny][nx] == 0 && maps[ny][nx].equals("L")) {
                    visited[ny][nx] = visited[front.y][front.x] + 1;
                    max = Math.max(visited[front.y][front.x] + 1, max);
                    queue.add(new Node(ny, nx));
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        maps = new String[Y][X];
        visited = new int[Y][X];
        lands = new ArrayList<>();

        for (int i = 0; i < Y; i++) {
            String[] input = bf.readLine().split("");
            for (int j = 0; j < X; j++) {
                String resource = input[j];
                if (resource.equals("L")) {
                    lands.add(new Node(i, j));
                }
                maps[i][j] = resource;
            }
        }

        max = Integer.MIN_VALUE;

        for (int i = 0; i < lands.size(); i++) {
            visited = new int[Y][X];
            BFS(lands.get(i));
        }

        System.out.println(max - 1);
    }

}