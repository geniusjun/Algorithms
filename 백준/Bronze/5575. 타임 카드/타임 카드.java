import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);


        for(int i = 0; i<3; ++i){
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int s1 = sc.nextInt();
            int H = h1 -h;
            int M = m1- m;
            int S = s1 -s;
            if(S< 0){
                S += 60;
                M--;
            }
            if(M < 0){
                M += 60;
                H--;
            }
            System.out.println(H + " " + M + " " + S);

        }
    }
}

