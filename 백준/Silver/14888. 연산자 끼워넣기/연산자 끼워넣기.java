import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int mn, mx, N;
    static int[] arr;

    static void go(int idx, int result, int plus, int minus, int mul, int div) {
        if (idx == N) {
            mx = Math.max(result, mx);
            mn = Math.min(result, mn);
            return;
        }

        if (plus > 0) {
            go(idx + 1, result + arr[idx], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            go(idx + 1, result - arr[idx], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            go(idx + 1, result * arr[idx], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            int ret;
            if (result == 0) {
                ret = 0;
            } else if (result < 0) {
                ret = (-1) * (Math.abs(result) / arr[idx]);
            } else {
                ret = result / arr[idx];
            }
            go(idx + 1, ret, plus, minus, mul, div - 1);
        }
    }

    // deque로?
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        mx = Integer.MIN_VALUE;
        mn = Integer.MAX_VALUE;
        go(1, arr[0], plus, minus, mul, div);

        System.out.println(mx);
        System.out.println(mn);
    }
}