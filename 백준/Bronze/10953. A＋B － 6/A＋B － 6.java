import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            String[] arr = input.split(",");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            System.out.println(a+b);
        }
    }
}