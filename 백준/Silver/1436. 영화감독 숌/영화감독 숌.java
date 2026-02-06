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
            for (int i = 0; i < check.length() - 2; i++) {
                if (check.charAt(i) == '6' && check.charAt(i + 1) == '6' && check.charAt(i + 2) == '6') {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(ret);
    }
}