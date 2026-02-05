import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(bf.readLine());
            int twoCnt = 0;
            int fiveCnt = 0;
            for (int j = 2; j <= number; j *= 2) {
                twoCnt += number / j;
            }
            for (int k = 5; k <= number; k *= 5) {
                fiveCnt += number / k;
            }

            System.out.println(Math.min(twoCnt, fiveCnt));
        }
    }
}