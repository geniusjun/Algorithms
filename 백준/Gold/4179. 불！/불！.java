
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
    static int[][] fireVisited;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Node jihoon;
    static List<Node> fires;
    static Node fire;
    static boolean isSafe;
    static int ret;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void goFire(Node fire) {
        fireVisited[fire.y][fire.x] = 1;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(fire);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= Y || nx >= X || maps[ny][nx].equals("#")) {
                    continue;
                }
                if ((fireVisited[ny][nx] > fireVisited[front.y][front.x] + 1)
                        || fireVisited[ny][nx] == 0) { // 불이 여러개일때를 생각.
                    fireVisited[ny][nx] = fireVisited[front.y][front.x] + 1;
                    queue.add(new Node(ny, nx));
                }
            }
        }
    }

    static void goJihoon(Node jihoon) {
        visited[jihoon.y][jihoon.x] = 1;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(jihoon);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                    isSafe = true;
                    ret = Math.min(ret, visited[front.y][front.x]);
                    continue;
                }
                if (maps[ny][nx].equals("#") || (fireVisited[ny][nx] != 0
                        && fireVisited[ny][nx] <= visited[front.y][front.x] + 1)) {
                    continue;
                }
                if (maps[ny][nx].equals(".") && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[front.y][front.x] + 1;
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
        fires = new ArrayList<>();

        for (int i = 0; i < Y; i++) {
            String[] inputs = bf.readLine().split("");
            for (int j = 0; j < X; j++) {
                String input = inputs[j];
                if (input.equals("J")) {
                    jihoon = new Node(i, j);
                } else if (input.equals("F")) {
                    fires.add(new Node(i, j));
                }
                maps[i][j] = input;
            }
        }
        ret = Integer.MAX_VALUE;
        fireVisited = new int[Y][X];
        for (int i = 0; i < fires.size(); i++) {
            goFire(fires.get(i));
        }
        visited = new int[Y][X];
        isSafe = false;
        goJihoon(jihoon);

        if (isSafe) {
            System.out.println(ret);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}