import java.io.*;
import java.util.*;

public class 가장 긴 증가하는 부분수열 {

    static int N;
    static int[] arr;
    static int[] trace;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        trace = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

            if (lis.isEmpty() || lis.get(lis.size() - 1) < arr[i]) {

                lis.add(arr[i]);
                trace[i] = lis.size() - 1;

            } else {

                int idx = Collections.binarySearch(lis, arr[i]);

                if (idx < 0) {
                    idx = -(idx + 1);
                }

                lis.set(idx, arr[i]);
                trace[i] = idx;
            }
        }

        int len = lis.size();

        int[] answer = new int[len];

        int target = len - 1;

        for (int i = N - 1; i >= 0; i--) {

            if (trace[i] == target) {

                answer[target] = arr[i];
                target--;

                if (target < 0) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(len).append('\n');

        for (int num : answer) {
            sb.append(num).append(' ');
        }

        System.out.println(sb);
    }
}