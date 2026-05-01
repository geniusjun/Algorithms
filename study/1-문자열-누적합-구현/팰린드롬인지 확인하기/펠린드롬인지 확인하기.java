import java.util.*;
import java.io.*;

public class 펠린드롬인지 확인하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean ispal = true;

        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                ispal = false;
                break;
            }
        }

        if(ispal){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
}
