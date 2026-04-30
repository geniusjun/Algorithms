import java.util.*;
import java.io.*;

public class 알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a = 97
        String s = br.readLine();
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
