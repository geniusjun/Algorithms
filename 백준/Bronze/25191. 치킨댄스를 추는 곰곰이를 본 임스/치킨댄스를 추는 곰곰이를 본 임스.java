import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        int A = sc.nextInt(); //coke
        int B = sc.nextInt(); //beer

        if(N<= A/2 + B){
            System.out.println(N);
        } else{
            System.out.println(A/2 + B);
        }
    }
}

