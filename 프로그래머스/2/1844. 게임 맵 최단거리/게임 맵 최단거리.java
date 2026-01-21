import java.util.*;

class Solution {
    
    public static final int[] dr = {0, 0, 1, -1};
    public static final int[] dc = {1, -1, 0, 0};

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        int[][] dist = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        dist[0][0] = 1;
        queue.addLast(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (maps[nr][nc] == 0) {
                    continue;
                }

                if (dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(nr, nc));
                }
            }
        }

        if (dist[N - 1][M - 1] == 0) {
            return -1;
        } else {
            return dist[N - 1][M - 1];
        }
    }
}