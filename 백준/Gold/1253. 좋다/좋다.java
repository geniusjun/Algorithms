import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(line1.nextToken());

        StringTokenizer line2 = new StringTokenizer(bf.readLine());
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add((long)Integer.parseInt(line2.nextToken()));
        }

        Collections.sort(list);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i) start++;
                else if (end == i) end--;
                else {
                    long sum = list.get(start) + list.get(end);
                    if (sum == list.get(i)) {
                        cnt++;
                        break;
                    }
                    else if (sum < list.get(i)) start++;
                    else end--;
                }
            }
        }
        System.out.println(cnt);

    }
}

