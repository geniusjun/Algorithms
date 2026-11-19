import java.util.*;
import java.io.*;

public class 농구 경기 {

    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for(int i = 0; i < n; i++){
            char c = br.readLine().charAt(0);
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(arr[i] >= 5){
                sb.append((char)(i + 'a'));
            }
        }

        if(sb.isEmpty()){
            System.out.println("PREDAJA");
        } else{
            System.out.println(sb);
        }
    }
}