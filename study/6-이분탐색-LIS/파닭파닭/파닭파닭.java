import java.io.*;
import java.util.*;

public class 파닭파닭 {

    static long S, C, sum, ret;
    static List<Long> list;

    static boolean check(long mid) {
        long cnt = 0;
        for (Long aLong : list) {
            cnt += (aLong / mid);
        }
        return cnt >= C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        list = new ArrayList<>();

        long r = Long.MIN_VALUE;
        sum = 0;
        for (int i = 0; i < S; i++) {
            list.add(Long.parseLong(br.readLine()));
            r = Math.max(list.get(i), r);
            sum += list.get(i);
        }

        long l = 1;
        ret = -1;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                ret = Math.max(ret, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.print(sum - (ret * C));

    }
}