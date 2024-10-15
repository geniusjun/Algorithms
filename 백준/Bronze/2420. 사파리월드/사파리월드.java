
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long M = sc.nextInt();
        long x = N-M;

        if(N-M <0){
            System.out.println((N-M) *(-1));
        }else{
            System.out.println(N-M);
        }

    }
}