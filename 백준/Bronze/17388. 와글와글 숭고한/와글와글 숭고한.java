import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();

        if(S+K+H >= 100){
            System.out.println("OK");
        } else {

            int M = Math.min(S, (Math.min(K, H)));
            if (M == S) {
                System.out.println("Soongsil");
            } else if (M == K) {
                System.out.println("Korea");
            } else if (M == H) {
                System.out.println("Hanyang");
            }
        }
    }
}
