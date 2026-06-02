import java.io.*;
import java.util.*;

public class 용돈 관리 {

    static int N, M, mx, sum, l, r, ret;
    static int[] arr;

    static boolean check(int mid){
        int cnt = 1;
        int temp = mid;
        for(int i = 0; i < N; i++){
            if(temp < arr[i]){
                temp = mid;
                cnt++;
            }
            temp -= arr[i];
        }


        return cnt <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = 0;
        mx = 0;
        ret = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, arr[i]);
            sum += arr[i];
        }

        l = mx;
        r = sum;

        while(l <= r){
            int mid = (l + r) / 2;
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