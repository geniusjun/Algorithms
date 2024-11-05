import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSum = Integer.MIN_VALUE;
        int[] arr = new int[5];
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt();
                sum += a;
            }
            arr[i] = sum;
            if(maxSum<sum){
                maxSum = sum;
                count = i;
            }
        }
        System.out.print(count+1 + " " + maxSum);
    }
}

