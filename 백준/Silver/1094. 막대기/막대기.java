import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        ret = 1;

        while (N != 1) {
            if ((N & 1) != 0) {
                ret++;
            }
            N /= 2;
        }

        System.out.println(ret);
    }
}