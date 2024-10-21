import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        if(month < 2 && day<=31){
            System.out.println("Before");
        } else if(month == 2 && day<18){
            System.out.println("Before");
        } else if (month == 2 && day > 18 && day<=31 ){
            System.out.println("After");
        } else if (month >= 3 && month<=12 && day>= 1 && day<=31){
            System.out.println("After");
        } else if (month == 2 && day == 18){
            System.out.println("Special");
        }
    }
}

