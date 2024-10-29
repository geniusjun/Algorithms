import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int count = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] >= max){
                max = arr[i];
                count = i;
            }
        }
        System.out.println(max);
        System.out.println(count+1);

    }
}

