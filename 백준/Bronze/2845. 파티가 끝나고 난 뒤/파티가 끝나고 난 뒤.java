import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int P = sc.nextInt();
        int[] arr = new int[5];
        


        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i : arr) {
            System.out.print(i - L*P + " ");
        }


    }
}

