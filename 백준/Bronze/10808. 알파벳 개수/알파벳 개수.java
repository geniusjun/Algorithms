import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        // 'a' = 97

        char[] arr = sc.next().toCharArray(); //

        int[] alphabet = new int[26];

        for(int i = 0; i<arr.length; i++){
            alphabet[(int)(arr[i] - 'a')]++;
        }
        for (int i : alphabet) {
            System.out.print(i + " ");
        }
        
    }
}

