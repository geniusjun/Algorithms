
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //대문자에서 32를 더하면 소문자가 된다.
        char[] text = sc.nextLine().toCharArray();
        for(int i = 0; i< text.length; i++){
            char temp = text[i];
            if(temp>='a' && temp<='z'){
                System.out.print((char)(temp-32));
            } else if (temp>='A' && temp<='Z'){
                System.out.print((char)(temp+32));
            }
        }
    }
}
