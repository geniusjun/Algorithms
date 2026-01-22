import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int[] num = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(bf.readLine());
            sum += num[i];
        }
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - num[i] - num[j] == 100) {
                    num1 = num[i];
                    num2 = num[j];
                    break;
                }
            }
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (num[i] == num1 || num[i] == num2) {
                continue;
            }
            System.out.println(num[i]);
        }

    }
}