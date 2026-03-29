import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;

    static void go(int[][] maps, int idx) {
        if (idx == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ret = Integer.max(maps[i][j], ret);
                }
            }
            return;
        }

        // 오른쪽 밀기
        go(right(maps), idx + 1);
        // 아래로 밀기
        go(down(maps), idx + 1);
        // 왼쪽 밀기
        go(left(maps), idx + 1);
        // 위로 밀기
        go(up(maps), idx + 1);
    }

    static int[][] right(int[][] maps) {
        int[][] rMaps = makeNewMap(maps);
        // 오른쪽으로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (rMaps[i][j] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j + cnt < N && rMaps[i][j + cnt] == 0) {
                    rMaps[i][j + cnt] = rMaps[i][j + cnt - 1];
                    rMaps[i][j + cnt - 1] = 0;
                    cnt++;
                }
            }
        }

        // 합치기
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (rMaps[i][j] == 0) {
                    continue;
                }
                if (rMaps[i][j + 1] == rMaps[i][j]) {
                    rMaps[i][j + 1] = rMaps[i][j + 1] * 2;
                    rMaps[i][j] = 0;
                    j--;
                }
            }
        }

        // 오른쪽으로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (rMaps[i][j] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j + cnt < N && rMaps[i][j + cnt] == 0) {
                    rMaps[i][j + cnt] = rMaps[i][j + cnt - 1];
                    rMaps[i][j + cnt - 1] = 0;
                    cnt++;
                }
            }
        }
        return rMaps;
    }

    static int[][] left(int[][] maps) {
        int[][] lMaps = makeNewMap(maps);
        // 왼쪽으로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (lMaps[i][j] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j - cnt >= 0 && lMaps[i][j - cnt] == 0) {
                    lMaps[i][j - cnt] = lMaps[i][j - cnt + 1];
                    lMaps[i][j - cnt + 1] = 0;
                    cnt++;
                }
            }
        }

        // 합치기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (lMaps[i][j] == 0) {
                    continue;
                }
                if (lMaps[i][j - 1] == lMaps[i][j]) {
                    lMaps[i][j - 1] = lMaps[i][j - 1] * 2;
                    lMaps[i][j] = 0;
                    j++;
                }
            }
        }

        // 왼쪽으로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (lMaps[i][j] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j - cnt >= 0 && lMaps[i][j - cnt] == 0) {
                    lMaps[i][j - cnt] = lMaps[i][j - cnt + 1];
                    lMaps[i][j - cnt + 1] = 0;
                    cnt++;
                }
            }
        }
        return lMaps;
    }

    static int[][] up(int[][] maps) {
        int[][] uMaps = makeNewMap(maps);
        // 위로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (uMaps[j][i] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j - cnt >= 0 && uMaps[j - cnt][i] == 0) {
                    uMaps[j - cnt][i] = uMaps[j - cnt + 1][i];
                    uMaps[j - cnt + 1][i] = 0;
                    cnt++;
                }
            }
        }

        // 합치기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (uMaps[j][i] == 0) {
                    continue;
                }
                if (uMaps[j - 1][i] == uMaps[j][i]) {
                    uMaps[j - 1][i] = uMaps[j - 1][i] * 2;
                    uMaps[j][i] = 0;
                    j++;
                }
            }
        }
        // 위로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (uMaps[j][i] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j - cnt >= 0 && uMaps[j - cnt][i] == 0) {
                    uMaps[j - cnt][i] = uMaps[j - cnt + 1][i];
                    uMaps[j - cnt + 1][i] = 0;
                    cnt++;
                }
            }
        }
        return uMaps;
    }

    static int[][] down(int[][] maps) {
        int[][] dMaps = makeNewMap(maps);

        // 아래로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (dMaps[j][i] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j + cnt < N && dMaps[j + cnt][i] == 0) {
                    dMaps[j + cnt][i] = dMaps[j + cnt - 1][i];
                    dMaps[j + cnt - 1][i] = 0;
                    cnt++;
                }
            }
        }

        // 합치기
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (dMaps[j][i] == 0) {
                    continue;
                }
                if (dMaps[j + 1][i] == dMaps[j][i]) {
                    dMaps[j + 1][i] = dMaps[j + 1][i] * 2;
                    dMaps[j][i] = 0;
                    j--;
                }
            }
        }

        // 아래로 다 이동
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (dMaps[j][i] == 0) {
                    continue;
                }
                int cnt = 1;
                while (j + cnt < N && dMaps[j + cnt][i] == 0) {
                    dMaps[j + cnt][i] = dMaps[j + cnt - 1][i];
                    dMaps[j + cnt - 1][i] = 0;
                    cnt++;
                }
            }
        }
        return dMaps;
    }


    static int[][] makeNewMap(int[][] maps) {
        int[][] dMaps = new int[N][N]; // 참조 끊어서 새로 만들어주기, 원복 안하려고.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dMaps[i][j] = maps[i][j];
            }
        }
        return dMaps;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = Integer.MIN_VALUE;
        go(maps, 0);

        System.out.println(ret);
    }
}
