import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] prev = new int[N];

        Arrays.fill(prev, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int maxLen = 1;
        int lastIdx = 0;

        for(int i = 0; i < N; i++){

            for(int j = 0; j < i; j++){

                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        Stack<Integer> stack = new Stack<>();

        while(lastIdx != -1){
            stack.push(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(maxLen).append('\n');

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}