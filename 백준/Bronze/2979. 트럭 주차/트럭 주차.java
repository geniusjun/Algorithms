import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];

        for (int i = 0; i < 3; i++) {
            StringTokenizer time = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(time.nextToken());
            int end = Integer.parseInt(time.nextToken());
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }
        int num = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] == 1) {
                num += A;
            } else if (arr[i] == 2) {
                num += B * 2;
            } else if (arr[i] == 3) {
                num += C * 3;
            }
        }

        System.out.println(num);
    }


}