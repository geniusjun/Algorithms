import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, K, ret;
    static List<Order> orders;
    static int[] visited;

    static class Order {
        Node start;
        Node end;

        Order(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void go(int[][] maps, int idx) {
        if (idx == orders.size()) {
            // A값 최신화
            ret = Integer.min(ret, findA(maps));
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }
            // 회전
            visited[i] = 1;
            go(rotate(maps, orders.get(i)), idx + 1);
            visited[i] = 0; // 모든 회전을 다 사용해야하므로 원복 필수
        }

    }

    static int[][] rotate(int[][] maps, Order order) {
        int[][] rMaps = new int[Y][X]; // 참조 끊기
        int rotateCnt = (order.end.y - order.start.y) / 2;
        for (int i = 0; i < rotateCnt; i++) {
            // 위
            for (int j = order.start.x + i; j <= order.end.x - 1 - i; j++) {
                rMaps[order.start.y + i][j + 1] = maps[order.start.y + i][j];
            }
            // 오른쪽
            for (int j = order.start.y + i; j <= order.end.y - 1 - i; j++) {
                rMaps[j + 1][order.end.x - i] = maps[j][order.end.x - i];
            }

            // 아래
            for (int j = order.end.x - i; j >= order.start.x + 1 + i; j--) {
                rMaps[order.end.y - i][j - 1] = maps[order.end.y - i][j];
            }

            // 왼쪽
            for (int j = order.end.y - i; j >= order.start.y + 1 + i; j--) {
                rMaps[j - 1][order.start.x + i] = maps[j][order.start.x + i];
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (rMaps[i][j] == 0) {
                    rMaps[i][j] = maps[i][j];
                }
            }
        }

        return rMaps;
    }

    static int findA(int[][] maps) {
        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i < Y; i++) {
            int sum = 0;
            for (int j = 0; j < X; j++) {
                sum += maps[i][j];
            }
            cnt = Integer.min(cnt, sum);
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] maps = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        orders = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            orders.add(new Order(new Node(r - s - 1, c - s - 1), new Node(r + s - 1, c + s - 1)));
        }

        ret = Integer.MAX_VALUE;
        visited = new int[K];
        go(maps, 0);

        System.out.println(ret);
    }
}
