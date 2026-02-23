import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, ret;
    static int[][] maps;
    static int[][] ladder;

    static void go(int here, int idx) {
        if (idx > 3) {
            return;
        }
        if (idx >= ret) {
            return;
        }

        if (isOkay()) {
            ret = Math.min(idx, ret);
            return;
        }

        for (int i = here; i < H; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (ladder[i][j] == -1 && ladder[i][j + 1] == -1) {
                    ladder[i][j] = j + 1;
                    ladder[i][j + 1] = j;
                    go(i, idx + 1);
                    ladder[i][j] = -1;
                    ladder[i][j + 1] = -1;
                }
            }
        }

    }

    static boolean isOkay() {
        boolean isHere = true;
        for (int i = 0; i < N; i++) {
            int here = i;
            for (int j = 0; j < H; j++) {
                if (ladder[j][here] != -1) {
                    here = ladder[j][here];
                }
            }
            if (here != i) {
                isHere = false;
            }
        }
        return isHere;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ret = Integer.MAX_VALUE;

        maps = new int[H][N];
        ladder = new int[H][N];
        for (int i = 0; i < H; i++) {
            Arrays.fill(ladder[i], -1);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(line.nextToken()) - 1;
            int c = Integer.parseInt(line.nextToken()) - 1;
            ladder[r][c] = c + 1;
            ladder[r][c + 1] = c;
        }

        go(0, 0);

        if (ret > 3) {
            System.out.println(-1);
        } else {
            System.out.println(ret);
        }

    }
}