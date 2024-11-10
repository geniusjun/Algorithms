import java.util.Scanner;

import static java.lang.String.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        char[] arr1 = valueOf(A).toCharArray();
        char[] arr2 = valueOf(B).toCharArray();

        int[] arr3 = new int[3];
        int[] arr4 = new int[3];

        arr3[0] = Integer.parseInt(String.valueOf(arr1[2])) * 100;
        arr3[1] = Integer.parseInt(String.valueOf(arr1[1])) * 10;
        arr3[2] = Integer.parseInt(String.valueOf(arr1[0]));

        arr4[0] = Integer.parseInt(String.valueOf(arr2[2])) * 100;
        arr4[1] = Integer.parseInt(String.valueOf(arr2[1])) * 10;
        arr4[2] = Integer.parseInt(String.valueOf(arr2[0]));

        int a =  arr3[0] +arr3[1] +arr3[2];
        int b =  arr4[0] +arr4[1] +arr4[2];

        System.out.println(Math.max(a,b));

    }
}