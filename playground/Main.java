import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            arr[ch - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            while(arr[i] >= 2){
                sb.append((char) (i + 'A'));
                arr[i] -= 2;
            }
        }
        char ch = 0;
        int oneCnt = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] == 1){
                oneCnt++;
                arr[i]--;
                ch = ((char) (i + 'A'));
            }
        }
        String before = String.valueOf(sb);
        sb.reverse();
        if(oneCnt > 1){
            System.out.println("I'm Sorry Hansoo");
        } else{
            if(oneCnt == 1 ) {
                System.out.println(before + String.valueOf(ch) + sb);
            } else{
                System.out.println(before + sb);
            }
        }
    }
}