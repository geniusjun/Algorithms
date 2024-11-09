import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr1 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr1[i] = -1;
        }

        String s = sc.nextLine();

        char[] arr2 = s.toCharArray();
        int [] arr3 = new int[arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr2[i] - '0';
        }
        for (int i = 0; i < arr2.length; i++) {
            if(arr1[arr3[i]] == -1) {
                arr1[arr3[i]] = i;
            }
        }

        for (int i = 49; i < 75 ; i++) {
            System.out.print(arr1[i] + " " );
        }
    }
}