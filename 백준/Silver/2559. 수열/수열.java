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
        int sum = 0;
        int[] arr = new int[N];
        StringTokenizer numbers = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbers.nextToken());
        }
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = 0; i < arr.length - K; i++) {
            sum -= arr[i];
            sum += arr[i + K];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}