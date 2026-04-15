import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int want, m, n, ret;
    static int[] a, b;
    static int[] pSumA, pSumB;
    static Map<Integer, Integer> aCnt = new HashMap<>();
    static Map<Integer, Integer> bCnt = new HashMap<>();

    static void make(int n, int[] pSum, Map<Integer, Integer> map) {
        for (int interval = 1; interval <= n; interval++) {
            for (int start = interval; start <= n + interval - 1; start++) {
                int sum = pSum[start] - pSum[start - interval];
                map.put(sum, map.getOrDefault(sum, 0) + 1);

                if (interval == n) {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        want = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 1];
        b = new int[m + 1];
        pSumA = new int[2 * n + 1];
        pSumB = new int[2 * m + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            pSumA[i] = pSumA[i - 1] + a[i];
        }
        for (int i = n + 1; i <= 2 * n; i++) {
            pSumA[i] = pSumA[i - 1] + a[i - n];
        }

        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(br.readLine());
            pSumB[i] = pSumB[i - 1] + b[i];
        }

        for (int i = m + 1; i <= 2 * m; i++) {
            pSumB[i] = pSumB[i - 1] + b[i - m];
        }

        make(n, pSumA, aCnt);
        make(m, pSumB, bCnt);

        int ret = aCnt.getOrDefault(want, 0) + bCnt.getOrDefault(want, 0);

        for (int i = 1; i < want; i++) {
            ret += aCnt.getOrDefault(i, 0) * bCnt.getOrDefault(want - i, 0);
        }

        System.out.println(ret);

    }
}