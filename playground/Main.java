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

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        // 처음 K일 합 구하기
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        int mx = sum;

        // 한 칸씩 밀면서 합 갱신
        for (int i = K; i < N; i++) {
            sum += arr[i];       // 새로 들어오는 값
            sum -= arr[i - K];   // 빠지는 값

            mx = Math.max(mx, sum);
        }

        System.out.println(mx);
    }
}