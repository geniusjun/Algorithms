import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        //1 : N 2:E 3: S 4: W
        int count = 1;

        for (int i = 0; i < 10; i++) {
            int x = sc.nextInt();
            if(x == 1){
                count += 1;
            } else if( x== 2){
                count += 2;
            } else if (x==3){
                count += 3;
            }
        }

        if(count %4 == 1){
            System.out.println("N");
        } else if(count %4 == 2){
            System.out.println("E");
        } else if(count %4 == 3){
            System.out.println("S");
        } else if (count %4 == 0){
            System.out.println("W");
        }
    }
}
