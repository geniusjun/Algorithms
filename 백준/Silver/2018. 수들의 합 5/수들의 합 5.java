import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end != N){
            if(sum == N){
                cnt++;
                end++;
                sum += end;
            }
            else if(sum < N){
                end++;
                sum += end;
            }
            else {
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);
    }
}

