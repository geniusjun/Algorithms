import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        long ans = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);

            int val;
            if ('0' <= c && c <= '9') val = c - '0';
            else val = c - 'A' + 10;

            ans = ans * B + val;
        }

        System.out.println(ans);
    }
}