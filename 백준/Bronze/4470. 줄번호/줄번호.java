
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextLine();
            System.out.println((i+1) + ". " + input[i]);
        }

    }
}

