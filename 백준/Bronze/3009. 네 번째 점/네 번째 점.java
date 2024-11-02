import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int a = 0;
        int b = 0;

        if(x1==x2) a = x3;
        else if(x1 == x3) a =x2;
        else if(x2 == x3) a = x1;

        if(y1== y2) b = y3;
        else if (y1 == y3) b= y2;
        else if(y2 == y3) b = y1;

        System.out.println(a+ " "+ b);
        }
    }



