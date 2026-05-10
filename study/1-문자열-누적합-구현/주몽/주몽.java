import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 주몽 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long M = Integer.parseInt(br.readLine());

        int ret = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2 7 4 1 5 3
        // 1 2 3 4 5 7

        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        while(l < r){
            if(arr[l] + arr[r] < M){
                l++;
            } else if(arr[l] + arr[r] > M){
                r--;
            } else{
                if(arr[l] == arr[r]){
                    long cnt = r - l + 1;
                    ret += cnt * (cnt - 1) / 2;
                    break;
                }

                int leftValue = arr[l];
                int rightValue = arr[r];

                long leftCnt = 0;
                long rightCnt = 0;

                while(l <= r && arr[l] == leftValue){
                    l++;
                    leftCnt++;
                }

                while(l <= r && arr[r] == rightValue){
                    rightCnt++;
                    r--;
                }

                ret += rightCnt * leftCnt;
            }
        }

        System.out.println(ret);
    }
}