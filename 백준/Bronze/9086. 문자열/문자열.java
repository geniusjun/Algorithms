
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        

        for(int i = 0; i < T; i++){
            String text = sc.nextLine();
            System.out.print(text.charAt(0));
            System.out.print(text.charAt(text.length() - 1));
            System.out.println();
        }
    }
}