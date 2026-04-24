import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 1;

        while((n % 2 == 0 && m % 2 == 0) || (n % 3 == 0 && m % 3 == 0) ){
            if(n % 2 == 0 && m % 2 == 0){
                n /= 2;
                m /= 2;
                cnt *= 2;
            }
            if(n % 3 == 0 && m % 3 == 0 ){
                n /= 3;
                m /= 3;
                cnt *= 3;
            }
        }
        System.out.println(cnt);
    
    }
}