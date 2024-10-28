import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if(count% 2 ==1){
                    System.out.print("*");
                    System.out.print(" ");
            } else{
                    System.out.print(" ");
                    System.out.print("*");
                }
            }
            System.out.println();
            count++;
        }
    }
}
