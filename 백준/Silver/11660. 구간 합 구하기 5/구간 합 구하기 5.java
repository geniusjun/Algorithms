
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+2][N+2];
        for(int i = 1; i <= N; i++){
            String nums = br.readLine();
            StringTokenizer numbers = new StringTokenizer(nums);
            for(int j = 1; j <= N; j++){
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(numbers.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            String index = br.readLine();
            StringTokenizer indexes = new StringTokenizer(index);
            int x1 = Integer.parseInt(indexes.nextToken());
            int y1 = Integer.parseInt(indexes.nextToken());
            int x2 = Integer.parseInt(indexes.nextToken());
            int y2 = Integer.parseInt(indexes.nextToken());
            int sum = 0;
            for(int j = x1; j <= x2; j++){
                sum += arr[j][y2] - arr[j][y1 - 1];
            }
            System.out.println(sum);

        }
    }
}

