import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int base = a % 10;
            int result = 1;

            for (int i = 0; i < b; i++) {
                result = (result * base) % 10;
            }

            if (result == 0) {
                sb.append(10).append('\n');
            } else {
                sb.append(result).append('\n');
            }
        }

        System.out.print(sb);
    }
}