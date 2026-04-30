import java.util.*;
import java.io.*;

public class 트럭주차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[102];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            for(int j = start; j < last; j++){
                arr[j]++;
            }
        }
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            if(arr[i] == 1){
                sum += A;
            } else if(arr[i] == 2){
                sum += 2 * B;
            } else if(arr[i] == 3){
                sum += 3 * C;
            }
        }
        System.out.println(sum);
    }
}
