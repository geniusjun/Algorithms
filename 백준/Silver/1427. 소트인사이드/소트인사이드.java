import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (max < numbers[j]) {
                    max = numbers[j];
                    maxIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = max;
            numbers[maxIndex] = temp;
            sb.append(max);
        }
        System.out.println(sb);
    }
}