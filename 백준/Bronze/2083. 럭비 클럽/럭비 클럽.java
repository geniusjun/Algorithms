
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        while (true){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String input = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());


            if(input.equals("#") && age == 0 && height == 0){
                break;
            }

            if(age > 17 || height >=80){
                System.out.println(input + " Senior");
            } else{
                System.out.println(input + " Junior");
            }
        }

    }
}
