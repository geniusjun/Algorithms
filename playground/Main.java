import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int mx = sum;
        for(int i = K; i < N; i++){
            sum -= arr[i-K];
            sum += arr[i];

            mx = Math.max(mx,sum);

        }

        System.out.println(mx);

    }
}