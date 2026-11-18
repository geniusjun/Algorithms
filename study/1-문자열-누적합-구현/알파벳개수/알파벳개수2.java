import java.util.*;
import java.io.*;

public class 알파벳개수2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[26];
        for(int i = 0; i < input.length(); i++){
            arr[input.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            System.out.print(arr[i] + " ");
        }
    }
}