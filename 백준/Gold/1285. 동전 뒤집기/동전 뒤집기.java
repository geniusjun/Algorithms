import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, ret;
    static int[] coins;

    static void go(int here) {

        if (here > N) {
            int sum = 0;
            for (int i = 1; i <= (1 << (N - 1)); i *= 2) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if ((coins[j] & i) != 0) {
                        cnt++;
                    }
                }
                sum += Math.min(cnt, N - cnt);
            }
            ret = Math.min(sum, ret);
            return;
        }

        go(here + 1);
        coins[here] = ~coins[here];
        go(here + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        coins = new int[N + 4];

        for (int i = 1; i <= N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'T') {
                    coins[i] |= (1 << j);
                }
            }
        }
        ret = Integer.MAX_VALUE;
        go(0);
        System.out.println(ret);
    }
}