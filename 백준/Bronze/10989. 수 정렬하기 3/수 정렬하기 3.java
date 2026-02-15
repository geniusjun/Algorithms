import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 수의 범위: 1 ~ 10000
        int[] count = new int[10001];

        // 입력 받으면서 개수 세기
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            count[value]++;
        }

        StringBuilder sb = new StringBuilder();

        // 작은 수부터 출력
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }

        System.out.print(sb);
    }
}
