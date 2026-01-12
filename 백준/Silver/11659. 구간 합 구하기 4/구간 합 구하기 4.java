import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];
        String nums = br.readLine();
        StringTokenizer tokens = new StringTokenizer(nums);
        for(int i = 1; i <= N; i++){
            numbers[i] = Integer.parseInt(tokens.nextToken());
        }
        int[] prefixSum = new int[N+1];
        for(int i = 1; i <= N; i++){
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }

        for(int i = 0; i < M; i++){
            String index = br.readLine();
            StringTokenizer indexes = new StringTokenizer(index);
            int start = Integer.parseInt(indexes.nextToken());
            int end = Integer.parseInt(indexes.nextToken());
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }

    }
}