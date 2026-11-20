import java.util.*;
import java.io.*;

public class 주몽2 {

    static int N, M, ret;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            if(arr[l] + arr[r] < M){
                l++;
            } else if(arr[l] + arr[r] > M){
                r--;
            } else{
                ret++;
                l++;
            }
        }

        System.out.println(ret);
    }

}