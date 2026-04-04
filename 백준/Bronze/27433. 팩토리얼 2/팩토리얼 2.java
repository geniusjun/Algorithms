import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long ret;

    // N개의 물웅덩이
    // 길이가 L인 널판지 충분히
    // 모든 물웅덩이를 덮기 위한 최소 널판지 갯수?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ret = 1;
        for (int i = N; i >= 1; i--) {
            ret *= i;
        }

        System.out.println(ret);
    }
}