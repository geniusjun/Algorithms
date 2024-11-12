import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[46];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= 45; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        int n = sc.nextInt();

        System.out.println(arr[n]);

    }
}