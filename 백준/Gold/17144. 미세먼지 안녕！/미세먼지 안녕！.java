import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int Y, X, T, ret;
    static int[][] maps, visited;
    static int cleanerY;

    static void dustGo() {
        // 동시에 퍼져야 하기에 각각 퍼지는 값을 visited 배열에 축적하고 원본배열은 마이너스
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (maps[i][j] != 0) {
                    int dDust = maps[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (!canGo(ny, nx)) {
                            continue;
                        }
                        visited[ny][nx] += dDust;
                        maps[i][j] -= dDust;
                    }
                }
            }
        }
        // 원본배열에 퍼진 값 더해주기
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                maps[i][j] += visited[i][j];
            }
        }
    }

    static void cleanUp() { // 위쪽은 반시계방향
        //왼쪽부분 아래로 땡기기
        for (int i = cleanerY - 1; i >= 0; i--) {
            if (maps[i + 1][0] == -1) {
                maps[i][0] = 0;
                continue;
            }
            maps[i + 1][0] = maps[i][0];
            maps[i][0] = 0;
        }
        // 윗부분 왼쪽으로 한칸씩
        for (int i = 0; i < X - 1; i++) {
            maps[0][i] = maps[0][i + 1];
            maps[0][i + 1] = 0;
        }
        // 오른쪽부분 위로 땡기기
        for (int i = 1; i <= cleanerY; i++) {
            maps[i - 1][X - 1] = maps[i][X - 1];
            maps[i][X - 1] = 0;
        }
        // 아래부분 오른쪽으로 땡기기
        for (int i = X - 2; i >= 1; i--) {
            maps[cleanerY][i + 1] = maps[cleanerY][i];
            maps[cleanerY][i] = 0;
        }
    }

    static void cleanDown() { // 아래쪽은 시계방향
        int cleanerDownY = cleanerY + 1;
        // 왼쪽부분 위로 땡기기
        for (int i = cleanerDownY + 1; i <= Y - 1; i++) {
            if (maps[i - 1][0] == -1) {
                maps[i][0] = 0;
                continue;
            }
            maps[i - 1][0] = maps[i][0];
            maps[i][0] = 0;
        }
        // 아랫부분 왼쪽으로 땡기기
        for (int i = 1; i <= X - 1; i++) {
            maps[Y - 1][i - 1] = maps[Y - 1][i];
            maps[Y - 1][i] = 0;
        }
        // 오른쪽부분 아래로 땡기기
        for (int i = Y - 2; i >= cleanerDownY; i--) {
            maps[i + 1][X - 1] = maps[i][X - 1];
            maps[i][X - 1] = 0;
        }
        // 위쪽부분 오른쪽으로 땡기기
        for (int i = X - 2; i >= 1; i--) {
            maps[cleanerDownY][i + 1] = maps[cleanerDownY][i];
            maps[cleanerDownY][i] = 0;
        }
    }

    static boolean canGo(int y, int x) {
        if (y < 0 || x < 0 || y >= Y || x >= X || maps[y][x] == -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        maps = new int[Y][X];
        cleanerY = 0;

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1 && cleanerY == 0) { // 공기청정기는 위의 y값만 저장
                    cleanerY = i;
                }
                maps[i][j] = num;
            }
        }

        while (T-- > 0) {
            visited = new int[Y][X];
            dustGo();
            cleanUp();
            cleanDown();
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (maps[i][j] == 0 || maps[i][j] == -1) {
                    continue;
                }
                ret += maps[i][j];
            }
        }

        System.out.println(ret);
    }
}
