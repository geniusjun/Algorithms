
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = x;
        for(int i= 0; i<y; i++){
            System.out.println(x--);
        }
    }
}