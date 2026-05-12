import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 곱셈 {

    static long A, B, C;

    static long pow(long base, long jisu){
        if(jisu == 0) {
            return 1 % C;
        }

        long half = pow(base, jisu / 2);
        long result = (half * half) % C;

        if(jisu % 2 == 1){
            result = (result * base) % C;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }
}