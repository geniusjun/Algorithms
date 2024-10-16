
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException { //입력파일을 찾을 수 없거나

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        int X = sc.nextInt() - 50;
        int Y = sc.nextInt() - 50;


        int min1 = Math.min(Math.min(a+X,a+Y), Math.min(b+X, b+Y));
        int min = Math.min(min1, Math.min(c+X,c+Y));
        System.out.println(min);
    }
}

