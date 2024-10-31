import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] arr = input.toCharArray();

        int a = arr.length / 10;
        int b = arr.length % 10;
        int count = 0;

        for (int i = 0; i < a ; i++) {
            for (int j = count*10; j < (count+1)*10; j++) {
                System.out.print(arr[j]);
            }
            count++;
            System.out.println();
        }
        for (int i = count*10; i < count* 10 + b; i++) {
            System.out.print(arr[i]);
        }

        }
    }



