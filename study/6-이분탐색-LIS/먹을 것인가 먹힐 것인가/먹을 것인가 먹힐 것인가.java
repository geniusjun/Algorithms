import java.io.*;
import java.util.*;

public class 먹을 것인가 먹힐 것인가 {

    static int T, A, B, ret;
    static int[] arr, brr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[A];
            brr = new int[B];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < B; i++){
                brr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(brr);

            ret = 0;
            for(int i = 0; i < A; i++){
                int l = 0;
                int r = B - 1;
                while(l <= r){
                    int mid = (l + r) / 2;
                    if(brr[mid] < arr[i]){
                        l = mid + 1;
                    } else{
                        r = mid - 1;
                    }
                }
                ret += l;
            }

            System.out.println(ret);
        }

    }
}