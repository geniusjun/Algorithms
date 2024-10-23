import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];
        int sum = 0;
        int min1 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        min1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= min1) {
                min1 = arr[i];
            }
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        sum = sum - min1;

        System.out.println(sum + Math.max(a, b));
    }
}

