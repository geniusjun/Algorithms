import java.io.*;
import java.util.*;

public class 게임 {

    static int X, Y, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        ret = Integer.MAX_VALUE;

        long Z = ((long) Y * 100) / X;

        int l = 0, r = 1000000004;
        while(l <= r){
            int mid = (l + r) / 2;
            long newZ = ((long)(Y + mid) * 100) / (X + mid);
            if(newZ > Z){
                ret = Math.min(ret, mid);
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }



        if(ret == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(ret);
        }


    }
}