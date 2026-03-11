import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = 0;
        M = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String oper = st.nextToken();
            if (oper.equals("all")) {
                N = (1 << 21) - 1;
                continue;
            }
            if (oper.equals("empty")) {
                N = 0;
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            if (oper.equals("add")) {
                N |= (1 << x);
            } else if (oper.equals("remove")) {
                N &= ~(1 << x);
            } else if (oper.equals("check")) {
                if (((N & (1 << x)) != 0)) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (oper.equals("toggle")) {
                N ^= (1 << x);
            }
        }
        System.out.println(sb);
    }
}