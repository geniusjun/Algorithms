import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;

    // 방향: 0(→), 1(↑), 2(←), 3(↓)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited = new int[101][101];

    static void makeDragon(int x, int y, int d, int g) {
        ArrayList<Integer> dirs = new ArrayList<>();
        dirs.add(d);

        // 세대 확장
        for (int gen = 1; gen <= g; gen++) {
            for (int i = dirs.size() - 1; i >= 0; i--) {
                dirs.add((dirs.get(i) + 1) % 4);
            }
        }

        // 시작점 체크
        visited[y][x] = 1;

        // 방향대로 이동하며 점 표시
        for (int dir : dirs) {
            x += dx[dir];
            y += dy[dir];
            visited[y][x] = 1;
        }
    }

    static int countSquare() {
        int cnt = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] == 1 && visited[i][j + 1] == 1 && visited[i + 1][j + 1] == 1
                        && visited[i + 1][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeDragon(x, y, d, g);
        }

        ret = countSquare();

        System.out.println(ret);

    }

}
