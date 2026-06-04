import java.io.*;
import java.util.*;

public class 먹을 것인가 먹힐 것인가2 {

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

            Arrays.sort(arr);
            Arrays.sort(brr);


            ret = 0;
            int j = 0;
            for(int i = 0; i < A; i++){
                while(j < B && brr[j] < arr[i]){
                    j++;
                }
                ret += j;
            }

            System.out.println(ret);
        }

    }
}