import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(findResult(A, B, C));
    }

    static long findResult(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long half = findResult(A, B / 2, C);
        long result = (half * half) % C;

        if (B % 2 == 1) {
            result = (result * A) % C;
        }
        return result;


    }

}