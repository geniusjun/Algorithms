import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(line1.nextToken());

        StringTokenizer line2 = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(line2.nextToken());

        List<Integer> list = new ArrayList<>();
        StringTokenizer line3 = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(line3.nextToken()));
        }
        Collections.sort(list);
        int start = 0;
        int end = N-1;
        int cnt = 0;
        while (start < end){
            if(list.get(start) + list.get(end) == M){
                end--;
                cnt++;
            }
            else if(list.get(start) + list.get(end) < M){
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(cnt);
    }
}

