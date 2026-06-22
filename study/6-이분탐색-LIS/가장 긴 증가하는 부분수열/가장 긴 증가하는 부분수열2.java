import java.io.*;
import java.util.*;

public class 가장 긴 증가하는 부분수열2 {

    static int N;
    static int[] arr, pos;
    static List<Integer> lis;


    static int lowerBound(int target){
        int l = 0;
        int r = lis.size() - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(lis.get(mid) >= target){
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return l;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        pos = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        lis = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int idx = lowerBound(arr[i]);

            if(idx == lis.size()){
                lis.add(arr[i]);
            } else{
                lis.set(idx, arr[i]);
            }

            pos[i] = idx;
        }

        int target = lis.size() - 1;
        int[] ret = new int[lis.size()];

        for(int i = N - 1; i >= 0; i++){
            if(pos[i] == target){
                ret[target] = arr[i];
                target--;
            }
            if(target < 0){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++){
            sb.append(ret[i]).append(" ");
        }

        System.out.println(sb);
    }
}