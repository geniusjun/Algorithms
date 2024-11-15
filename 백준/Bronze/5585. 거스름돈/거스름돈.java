import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {500, 100, 50, 10, 5};

        int N = sc.nextInt();

        int x = 1000- N;
        int count = 0;

        for (int i = 0; i < 5; i++) {
            count += x/arr[i];
            x %= arr[i];
        }

        count += x;

        System.out.println(count);



    }
    }
