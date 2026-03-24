import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, X, ret;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        ret = 0;
        int l = 0;
        int r = N - 1;
        long now = arr[l] + arr[r];
        while (true) {
            if (l == r) {
                break;
            }

            if (now >= X) {
                if (now == X) {
                    ret++;
                }
                now -= arr[r];
                r--;
                now += arr[r];
            } else if (now < X) {
                now -= arr[l];
                l++;
                now += arr[l];
            }
        }
        System.out.println(ret);
    }
}
