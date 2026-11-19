import java.util.*;
import java.io.*;

public class 한국이 그리울 땐2 {

    static int n;
    static StringBuilder before, after;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String pt = br.readLine();
        before = new StringBuilder();
        after = new StringBuilder();

        boolean isStar = false;
        for(int i = 0; i < pt.length(); i++){
            char c = pt.charAt(i);
            if(c == '*'){
                isStar = true;
                continue;
            }
            if(!isStar){
                before.append(c);
            } else{
                after.append(c);
            }
        }
        after.reverse();
        int ptLength = before.length() + after.length();
        boolean isOkay = true;
        for(int i = 0; i < n; i++){
            isOkay = true;
            String input = br.readLine();
            if(input.length() < ptLength){
                System.out.println("NE");
                continue;
            }

            for(int j = 0; j < before.length(); j++){
                if(input.charAt(j) != before.charAt(j)){
                    isOkay = false;
                    break;
                }
            }
            for(int k = 0; k < after.length(); k++){
                if(input.charAt(input.length() - 1 - k) != after.charAt(k)){
                    isOkay = false;
                    break;
                }
            }

            if(isOkay){
                System.out.println("DA");
            } else{
                System.out.println("NE");
            }
        }

    }
}