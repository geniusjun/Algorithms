import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][][] visited;

    static class Node {
        int a;
        int b;
        int c;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int[][] damage = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = 0;
        int B = 0;
        int C = 0;
        if (N == 3) {
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        } else if (N == 2) {
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
        } else if (N == 1) {
            A = Integer.parseInt(st.nextToken());
        }
        visited = new int[61][61][61];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(A, B, C));
        visited[A][B][C] = 1;
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for (int i = 0; i < 6; i++) {
                int damagedA = Math.max(front.a - damage[i][0], 0);
                int damagedB = Math.max(front.b - damage[i][1], 0);
                int damagedC = Math.max(front.c - damage[i][2], 0);

                if (damagedA == 0 && damagedB == 0 && damagedC == 0) {
                    visited[0][0][0] = visited[front.a][front.b][front.c] + 1;
                    queue.clear();
                    break;
                }

                if (visited[damagedA][damagedB][damagedC] == 0) {
                    visited[damagedA][damagedB][damagedC] = visited[front.a][front.b][front.c] + 1;
                    queue.add(new Node(damagedA, damagedB, damagedC));
                }
            }
        }

        System.out.println(visited[0][0][0] - 1);

    }
}