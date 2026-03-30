import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int N, K, L, ret, sDir;
    static int[][] maps;
    static ArrayDeque<Node> snake;
    static ArrayDeque<Order> orders;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Order {
        int time;
        char dir;

        Order(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            maps[y - 1][x - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        snake = new ArrayDeque<>();
        orders = new ArrayDeque<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            orders.addLast(new Order(time, dir));
        }

        ret = 0;
        sDir = 0;
        snake.addLast(new Node(0, 0));
        while (true) {
            ret++;
            // 가기전에 벽이거나 자기 몸이면 game over
            Node head = snake.peekFirst();
            int ny = head.y + dy[sDir];
            int nx = head.x + dx[sDir];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                break;
            }
            ArrayDeque<Node> tempQ = new ArrayDeque<>();
            boolean isSnake = false;
            while (!snake.isEmpty()) {
                Node body = snake.pollFirst();
                if (body.y == ny && body.x == nx) {
                    isSnake = true;
                    break;
                }
                tempQ.addLast(body);
            }
            if (isSnake) {
                break;
            }
            snake = tempQ;
            // 사과가 있으면 머리만 증가, 없으면 머리 증가 후 꼬리 감소
            if (maps[ny][nx] == 0) {
                snake.addFirst(new Node(ny, nx));
                snake.pollLast();
            } else {
                snake.addFirst(new Node(ny, nx));
                maps[ny][nx] = 0;
            }

            // 다음 방향을 잡기 위해 방향 확인
            if (!orders.isEmpty()) {
                if (orders.peekFirst().time == ret) {
                    Order order = orders.pollFirst();
                    if (order.dir == 'L') {
                        sDir += 3;
                        sDir %= 4;
                    } else { // R
                        sDir += 1;
                        sDir %= 4;
                    }
                }
            }
        }
        System.out.println(ret);
    }
}
