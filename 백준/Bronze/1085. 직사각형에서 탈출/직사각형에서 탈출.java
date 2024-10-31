import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int a = w-x;
        int b = h-y;

        int min = Math.min(x,Math.min(y,Math.min(a,b)));
        System.out.println(min);
    }
}
