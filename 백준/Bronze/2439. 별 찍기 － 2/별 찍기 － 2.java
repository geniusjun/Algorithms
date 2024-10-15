
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for(int i = 1; i<=x; i++){ // 1 2 3 4 5
            for(int j = x; j>0; j--){ // 5 4 3 2 1
                if(j>i){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}

