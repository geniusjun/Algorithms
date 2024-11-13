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
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if(i%j == 0 ){
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber && (i != 1)) {
                sum += i;
                if(i<minNum) minNum = i;
                foundPrime = true;
            }
        }
        if(!foundPrime){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(minNum);
        }

        }
    }
