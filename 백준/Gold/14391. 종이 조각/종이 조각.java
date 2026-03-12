import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int answer = 0;

    static void dfs(int idx) {
        if (idx == N * M) {
            calc();
            return;
        }

        int y = idx / M;
        int x = idx % M;

        // 가로
        visited[y][x] = 1;
        dfs(idx + 1);

        // 세로
        visited[y][x] = 0;
        dfs(idx + 1);
    }

    static void calc() {
        int sum = 0;

        // 가로 계산
        for (int i = 0; i < N; i++) {
            int num = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 1) {
                    num = num * 10 + map[i][j];
                } else {
                    sum += num;
                    num = 0;
                }
            }
            sum += num;
        }

        // 세로 계산
        for (int j = 0; j < M; j++) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i][j] == 0) {
                    num = num * 10 + map[i][j];
                } else {
                    sum += num;
                    num = 0;
                }
            }
            sum += num;
        }

        answer = Math.max(answer, sum);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0);

        System.out.println(answer);
    }
}