import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        char[] arr = input.toCharArray();
        char[] arr2 = new char[arr.length];
        int count = 0;
        for (int i = arr.length-1; i >=0 ; i--) {
            arr2[count] = arr[i];
            count++;
        }


        if(Arrays.equals(arr, arr2)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

        }
    }



