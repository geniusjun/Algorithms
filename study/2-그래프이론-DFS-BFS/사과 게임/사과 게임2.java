import java.util.*;
import java.io.*;

public class 사과게임2{

    static int N, M, J, apple, ret;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        int l = 1;
        int r;
        for(int i = 0; i < J; i++){
            r = l + M - 1;
            apple = Integer.parseInt(br.readLine());
            if(l <= apple && apple <= r){
                continue;
            }
            if(l < apple){
                ret += apple - r;
                l += apple - r;
            } else{
                ret += l - apple;
                l -= l - apple;
            }
        }

        System.out.println(ret);
    }
}