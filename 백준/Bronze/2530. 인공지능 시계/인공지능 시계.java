import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        long h = sc.nextLong();
        long m = sc.nextLong();
        long s = sc.nextLong();

        long t = sc.nextLong();
        // 무조건 분 부터 계산

        s += t;


        m += s/60;
        s %= 60;

        h += m/60;
        m %= 60;


        h %= 24;


        System.out.println(h + " " + m + " " + s);
    }
}