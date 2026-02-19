import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int Y, X;
    static char[][] maps;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int day;
    static ArrayDeque<Node> waterQ;
    static ArrayDeque<Node> swanQ;
    static ArrayDeque<Node> nextSwanQ;
    static Node swan1, swan2;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean swanMeet() {
        while (!swanQ.isEmpty()) {
            Node front = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if (ny == swan2.y && nx == swan2.x) {
                    return true;
                }

                if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;

                if (maps[ny][nx] == 'X') {
                    nextSwanQ.add(new Node(ny, nx));
                }
                if (maps[ny][nx] == '.') {
                    swanQ.add(new Node(ny, nx));
                }
            }
        }
        return false;
    }

    static ArrayDeque<Node> melt() {
        ArrayDeque<Node> nextWaterQ = new ArrayDeque<>();
        while (!waterQ.isEmpty()) {
            Node front = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                    continue;
                }
                if (maps[ny][nx] == 'X') {
                    maps[ny][nx] = '.';
                    nextWaterQ.add(new Node(ny, nx));
                }
            }
        }
        return nextWaterQ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        waterQ = new ArrayDeque<>();
        swanQ = new ArrayDeque<>();
        nextSwanQ = new ArrayDeque<>();
        maps = new char[Y][X];
        visited = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            String line = bf.readLine();
            for (int j = 0; j < X; j++) {
                char input = line.charAt(j);
                if (input != 'X') {
                    waterQ.add(new Node(i, j));
                }
                if (input == 'L') {
                    if (swan1 == null) {
                        swan1 = new Node(i, j);
                    } else {
                        swan2 = new Node(i, j);
                    }
                }
                maps[i][j] = input;
            }
        }

        day = 0;
        visited[swan1.y][swan1.x] = true;
        swanQ.add(swan1);
        while (true) {
            if (swanMeet()) {
                System.out.println(day);
                break;
            }

            waterQ = melt();

            swanQ = nextSwanQ;
            nextSwanQ = new ArrayDeque<>();
            day++;
        }
    }
}