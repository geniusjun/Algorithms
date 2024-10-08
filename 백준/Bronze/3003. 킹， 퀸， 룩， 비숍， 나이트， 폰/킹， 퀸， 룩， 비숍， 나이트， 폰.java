import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int king = 1 - a;
        int queen = 1 - b;
        int look = 2 - c;
        int bishop = 2 - d;
        int knight = 2 -  e;
        int pawn = 8 - f;

        System.out.print(king);
        System.out.print(" ");
        System.out.print(queen);
        System.out.print(" ");
        System.out.print(look);
        System.out.print(" ");
        System.out.print(bishop);
        System.out.print(" ");
        System.out.print(knight);
        System.out.print(" ");
        System.out.println(pawn);



    }
}

