
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int S = sc.nextInt();

        System.out.println(input.charAt(S-1));
    }
}
