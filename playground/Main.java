import java.io.*;
import java.util.*;

public class Main {

    static int N, ret;
    static int[] arr, cnt, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cnt = new int[N];

        prev = new int[N];
        Arrays.fill(prev, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        ret = 0;
        int lastIdx = 0;
        for(int i = 0; i < N; i++){
            int maxValue = 0;
            int prevIdx = -1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && cnt[j] > maxValue){
                    maxValue = cnt[j];
                    prevIdx = j;
                }
            }
            cnt[i] = maxValue + 1;
            prev[i] = prevIdx;
            if(ret < cnt[i]){
                ret = cnt[i];
                lastIdx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(lastIdx != -1){
            list.add(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        System.out.println(ret);
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.print(list.get(i) + " ");
        }



    }
}