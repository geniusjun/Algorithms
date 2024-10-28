
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if(A+B>=C*2) {
            System.out.println((A+B)-(C*2));
        } else{
            System.out.println(A+B);
        }
    }
}

