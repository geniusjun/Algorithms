import java.util.*;
import java.io.*;

public class Main {

    static int A, B, C;
    static int start = -1;
    static int end = -1;
    static int ret = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for(int j = start; j < end; j++){
                arr[j]++;
            }
        }

        for(int i = 0; i <= 100; i++){
            if(arr[i] == 1){
                ret += A;
            } else if(arr[i] == 2){
                ret += B * 2;
            } else if(arr[i] == 3){
                ret += C * 3;
            }
        }

        System.out.println(ret);

    }
}