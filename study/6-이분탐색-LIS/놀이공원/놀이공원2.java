import java.io.*;
import java.util.*;

public class 놀이공원2 {

    static int M;
    static long N, time;
    static int[] rides;

    static long countPeople(long time){
        long cnt = M;
        for(int i = 0; i < M; i++){
            cnt += time / rides[i];
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N <= M){
            System.out.println(N);
            return;
        }

        rides = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            rides[i] = Integer.parseInt(st.nextToken());
        }

        long l = 1;
        long r = 60000000004L;
        time = 0;
        while(l <= r){
            long mid = (l + r) / 2;
            if(countPeople(mid) >= N){
                time = mid;
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }

        long before = countPeople(time - 1);

        for(int i = 0; i < M; i++){
            if(time % rides[i] == 0) {
                before++;

                if (before == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

    }
}