import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    // BFS with state: (r, c, broken)
    static int bfs() {
        // dist[r][c][b]: b=0(아직 안 부숨), b=1(이미 하나 부숨)
        int[][][] dist = new int[N][M][2];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        dist[0][0][0] = 1;           // 시작 칸도 거리 포함
        q.add(new int[]{0, 0, 0});   // r, c, broken

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], b = cur[2];

            if (r == N - 1 && c == M - 1) {
                return dist[r][c][b]; // 최단 거리
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == '0') {
                    // 그냥 이동 (벽을 더 안 부숨)
                    if (dist[nr][nc][b] == 0) {
                        dist[nr][nc][b] = dist[r][c][b] + 1;
                        q.add(new int[]{nr, nc, b});
                    }
                } else { // '1' 벽
                    // 아직 안 부쉈다면 이번에 하나 부수고 이동
                    if (b == 0 && dist[nr][nc][1] == 0) {
                        dist[nr][nc][1] = dist[r][c][0] + 1;
                        q.add(new int[]{nr, nc, 1});
                    }
                }
            }
        }
        return -1; // 도달 불가
    }
}
