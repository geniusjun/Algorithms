
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        if(A== 1){
            System.out.println(0);
        }
        else if(A/2 <= B){
            System.out.println(A/2);
        } else {
            System.out.println(B);
        }
    }
}

