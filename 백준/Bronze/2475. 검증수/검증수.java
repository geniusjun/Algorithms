import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[5];
        int a = 0;
        for (int i = 0; i<x.length; i++){
            x[i] = sc.nextInt();
            a += x[i]*x[i];
        }
        System.out.println(a%10);

    }
}

