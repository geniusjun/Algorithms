import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int ret = 666;
        int cnt = 1;
        while (cnt != N) {
            ret++;
            String check = String.valueOf(ret);
            if (check.contains("666")) {
                cnt++;
            }
        }
        System.out.println(ret);
    }

}