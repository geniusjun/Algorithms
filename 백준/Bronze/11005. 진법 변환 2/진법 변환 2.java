import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int rem = N % B;

            if (rem < 10) {
                sb.append(rem);
            } else {
                sb.append((char) ('A' + (rem - 10)));
            }

            N /= B;
        }

        System.out.println(sb.reverse());
    }
}