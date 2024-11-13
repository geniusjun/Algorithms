import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        char[] input = String.valueOf(N).toCharArray();

        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = input[i] - '0';
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) { // 1부터 N-1까지 반복
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10; // 각 자릿수를 더함
                temp /= 10;
            }

            if (sum == N) {
                min = Math.min(min, i);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0); // 생성자가 없을 경우
        } else {
            System.out.println(min); // 생성자가 있을 경우 최솟값 출력
        }


    }
}