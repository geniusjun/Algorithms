import java.util.*;
import java.io.*;

public class 펠린드롬인지 확인하기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean isPal = true;
        for(int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                isPal = false;
            }
        }

        if(isPal){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
}