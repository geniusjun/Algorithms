import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 교수가 된 현우 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            int two = 0;
            int five = 0;

            for(int i = 2; i <= num; i*=2){
                two += num / i;
            }

            for(int i = 5; i <= num; i*=5){
                five += num / i;
            }

            System.out.println(Math.min(two, five));
        }

    }
}