import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long N, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long cnt = 2;
        while (cnt <= N) {
            while (N % cnt == 0) {
                sb.append(cnt).append("\n");
                N /= cnt;
            }
            cnt++;
        }

        System.out.println(sb);
    }
}
