
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            System.out.println(arr[i].toLowerCase());
        }
    }
}
