import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int a = 25;
        int b = 10;
        int c = 5;
        int d = 1;
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int A = M/a;
            M %= a;
            int B = M/b;
            M %= b;
            int C = M/c;
            M %= c;
            int D = M/d;
            M %= d;
            System.out.println(A + " " + B + " " + C + " " + D);
        }
    }
}

