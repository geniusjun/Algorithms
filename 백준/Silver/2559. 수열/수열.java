import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        StringTokenizer numbers = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(numbers.nextToken());
            arr[i] = arr[i - 1] + temp;
        }
        int ret = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            ret = Math.max(ret, arr[i] - arr[i - K]);
        }
        System.out.println(ret);
    }
}