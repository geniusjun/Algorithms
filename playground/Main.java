import java.util.*;
import java.io.*;

public class Main {

    // A = 65, Z = 90
    // a = 97, z = 122
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c >= 65 && c <= 90) {
                if(c + 13 > 90){
                    sb.append((char)(((c+13) % 91) + 65));
                } else{
                    sb.append((char)(c + 13));
                }
            } else if(c >= 97 && c <= 122){
                if(c + 13 > 122){
                    sb.append((char)(((c+13) % 123) + 97));
                } else{
                    sb.append((char)(c + 13));
                }
            } else{
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}