import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String grades = br.readLine();
        StringTokenizer st = new StringTokenizer(grades);

        int[] arr = new int[num];
        int max = 0;
        for(int i = 0; i < num; i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            max = Math.max(max, value);
        }
        double sum = 0;

        for(int i = 0; i < num; i++){
            sum += (double) arr[i] / max * 100;
        }

        double average = (double) sum / num;

        System.out.println(average);

    }
}