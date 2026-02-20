import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int Y;
    static int X;
    static char[][] maps;
    static int[][] visited;
    static Node swan;
    static ArrayDeque<Node> swanQ;
    static ArrayDeque<Node> nextSwanQ;
    static ArrayDeque<Node> waterQ;
    static int day;

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

                if (nx < 0 || ny < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0) {
                    continue;
                }
                if (maps[ny][nx] == '.') {
                    visited[ny][nx] = 1;
                    swanQ.add(new Node(ny, nx));
                } else if (maps[ny][nx] == 'X') {
                    visited[ny][nx] = 1;
                    nextSwanQ.add(new Node(ny, nx));
                } else if (maps[ny][nx] == 'L') {
                    return true;
                }
            }

        }
        return false;
    }

    static ArrayDeque<Node> melt() {
        ArrayDeque<Node> queue = new ArrayDeque<>();

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
                    queue.add(new Node(ny, nx));
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        maps = new char[Y][X];
        visited = new int[Y][X];
        waterQ = new ArrayDeque<>();

        for (int i = 0; i < Y; i++) {
            String line = bf.readLine();
            for (int j = 0; j < X; j++) {
                char input = line.charAt(j);
                if (input != 'X') {
                    waterQ.add(new Node(i, j));
                }
                if (input == 'L') {
                    swan = new Node(i, j);
                }
                maps[i][j] = input;
            }
        }

        day = 0;
        swanQ = new ArrayDeque<>();
        nextSwanQ = new ArrayDeque<>();
        swanQ.add(swan);
        visited[swan.y][swan.x] = 1;
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