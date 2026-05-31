import java.io.*;
import java.util.*;

public class 보석 상자 {

    static int child, color, ret;
    static int[] colors;

    static boolean check(int mid){
        long num = 0;
        for(int i = 0; i < color; i++){
            num += colors[i] / mid;
            if(colors[i] % mid != 0){
                num++;
            }
        }

        return num <= child;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        child = Integer.parseInt(st.nextToken());
        color = Integer.parseInt(st.nextToken());

        colors = new int[color];
        int l = 1;
        int r = 0;
        int mid;
        ret = Integer.MAX_VALUE;

        for(int i = 0; i < color; i++){
            colors[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, colors[i]);
        }

        while(l <= r){
            mid = (l + r) / 2;
            if(check(mid)){
                ret = Math.min(ret, mid);
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }

        System.out.println(ret);
    }
}