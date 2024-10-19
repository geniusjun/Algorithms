import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int S = 0;
        int T = 0;

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            S += a;
        }

        for (int i = 0; i < 4; i++) {
            int b = sc.nextInt();
            T += b;
        }

        if(S<T){
            System.out.println(T);
        } else {
            System.out.println(S);
        }


    }
}

