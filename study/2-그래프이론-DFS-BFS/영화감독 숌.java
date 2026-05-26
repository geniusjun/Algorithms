import java.io.*;
import java.util.*;

public class 영화감독 숌 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 665;

        while(cnt < N){
            num++;

            if(String.valueOf(num).contains("666")){
                cnt++;
            }
        }

        System.out.println(num);

    }
}