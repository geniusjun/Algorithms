import java.io.*;
import java.util.*;

public class Main {

    static long N;
    static int M;
    static int[] ride;

    static long count(long time) {
        long cnt = M; // 0분에 모든 놀이기구에 아이들이 바로 탑승

        for (int i = 0; i < M; i++) {
            cnt += time / ride[i];
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ride = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ride[i] = Integer.parseInt(st.nextToken());
        }

        // 아이 수가 놀이기구 수 이하라면 0분에 바로 번호 순서대로 탄다.
        if (N <= M) {
            System.out.println(N);
            return;
        }

        long l = 0;
        long r = 30L * N;
        long time = 0;

        // N번째 아이가 탑승 가능한 최소 시간을 찾는다.
        while (l <= r) {
            long mid = (l + r) / 2;

            if (count(mid) >= N) {
                time = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // time - 1분까지 탄 아이 수
        long before = count(time - 1);

        // time분에 타야 하는 아이 순서
        long remain = N - before;

        // time분에 비는 놀이기구를 번호 순서대로 확인
        for (int i = 0; i < M; i++) {
            if (time % ride[i] == 0) {
                remain--;

                if (remain == 0) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}