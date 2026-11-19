import java.util.*;
import java.io.*;

public class 수열 {

    static int N, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] psum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + num;
        }
        int max = Integer.MIN_VALUE;
        for(int i = K; i <= N; i++){
            max = Math.max(max, psum[i] - psum[i - K]);
        }

        System.out.println(max);
    }
}