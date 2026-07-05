import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] wire = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int lis = 1;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < i; j++) {

                if (wire[j][1] < wire[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            lis = Math.max(lis, dp[i]);
        }

        System.out.println(N - lis);
    }
}