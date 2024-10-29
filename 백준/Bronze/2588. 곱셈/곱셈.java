import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 숫자를 입력 받음
        int a = sc.nextInt();
        String b = sc.next();

        // 각 자리수와 곱한 결과를 출력
        int result1 = a * (b.charAt(2) - '0');
        int result2 = a * (b.charAt(1) - '0');
        int result3 = a * (b.charAt(0) - '0');

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        // 최종 곱셈 결과 출력
        int finalResult = a * Integer.parseInt(b);
        System.out.println(finalResult);
    }
}
