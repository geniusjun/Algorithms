import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        long cnt = 0;
        long sum = 0;
        long left = 1;

        for (long right = 1; right <= N; right++) {
            sum += right;

            while (sum > N) {
                sum -= left;
                left++;
            }

            if (sum == N) cnt++;
        }
        System.out.println(cnt);
    }
}

