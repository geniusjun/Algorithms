import java.io.*;

public class 연속부분최대곱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double cur = Double.parseDouble(br.readLine());
        double ans = cur;

        for (int i = 1; i < N; i++) {
            double x = Double.parseDouble(br.readLine());

            cur = Math.max(x, cur * x);
            ans = Math.max(ans, cur);
        }

        System.out.printf("%.3f\n", ans);
    }
}