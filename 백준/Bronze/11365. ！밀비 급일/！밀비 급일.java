import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        while(true){
            String text = sc.nextLine();
            if(text.equals("END")) break;

            char[] arr = text.toCharArray();
            for(int i = arr.length - 1; i>=0; i--){
                System.out.print(arr[i]);
            }
            System.out.println();

        }

    }
}
