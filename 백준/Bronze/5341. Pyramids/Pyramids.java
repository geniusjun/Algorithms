
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        while (true) {

            int sum = 0;
            int N = sc.nextInt();
            if(N ==0) {
                break;
            }
            for (int i = 1; i <=N ; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }
}

