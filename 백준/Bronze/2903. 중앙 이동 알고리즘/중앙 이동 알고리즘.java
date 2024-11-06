import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 각 변의 점 개수는 2^N + 1
        int length = (int) Math.pow(2, N) + 1;

        // 전체 점의 개수는 length * length
        int result = length * length;

        System.out.println(result);
    }
}