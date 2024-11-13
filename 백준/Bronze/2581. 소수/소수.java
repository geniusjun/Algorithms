import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int minNum = Integer.MAX_VALUE;
        int sum = 0;
        boolean foundPrime = false;

        for (int i = M; i <= N ; i++) {
            if (i < 2) continue; // 1은 소수가 아님

            boolean isPrimeNumber = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber) {
                sum += i;
                if(i < minNum) minNum = i;
                foundPrime = true;
            }
        }

        if(!foundPrime){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minNum);
        }
    }
}