import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String numbers = bf.readLine();
        StringTokenizer nums = new StringTokenizer(numbers);
        long[] pSum = new long[N+1];
        long[] C = new long[M];
        for(int i = 1; i <= N; i++){
            pSum[i] = pSum[i-1] + Integer.parseInt(nums.nextToken());
        }

        long cnt = 0;
        for(int i = 1; i <= N; i++){
            int remainer = (int) (pSum[i] % M );

            if( remainer == 0 ) cnt++;

            C[remainer]++;
        }

        for(int i = 0; i < M; i++){
            if(C[i] > 1){
                cnt += (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(cnt);
    }
}

