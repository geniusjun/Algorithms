import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            boolean isPrime = true;
            if(a == 1) isPrime = false;
            else{
                // 1보다 크고 약수가 자신과 1 이외에 없는 수가 소수.
                for (int j = 2; j < a; j++) {
                    if (a % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if(isPrime) count++;
        }
        System.out.println(count);
    }
}