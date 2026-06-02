import java.io.*;
import java.util.*;

public class 기타 레슨 {

    static int N, M, sum, l, r, mx, mid, ret;
    static int[] arr;

    static boolean check(int num){
        if(num < mx){
            return false;
        }
        int temp = num;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(num - arr[i] < 0){
                num = temp;
                cnt++;
            }
            num -= arr[i];
        }
        if(num != temp){
            cnt++;
        }

        return cnt <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mx = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            mx = Math.max(mx, arr[i]);
        }

        l = mx; r = sum;
        ret = Integer.MAX_VALUE;

        while(l <= r){
            mid = (l + r) / 2;
            if(check(mid)){
                ret = Math.min(mid, ret);
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }

        System.out.println(ret);

    }
}