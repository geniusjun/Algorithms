import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int time = a+b+c+d;

        int m = time/60;
        int s = time%60;
        System.out.println(m);
        System.out.println(s);
    }
}

