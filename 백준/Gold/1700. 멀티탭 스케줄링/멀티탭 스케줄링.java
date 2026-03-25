import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, K, ret;
    static int[] arr;
    static Set<Integer> plug;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 멀티탭 개수
        K = Integer.parseInt(st.nextToken()); // 사용 횟수

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        plug = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int now = arr[i];

            if (plug.contains(now)) {
                continue;
            }

            if (plug.size() < N) {
                plug.add(now);
                continue;
            }

            int target = -1;
            int fartest = -1;

            for (int p : plug) {
                int nextPos = Integer.MAX_VALUE;

                for (int j = i + 1; j < K; j++) {
                    if (arr[j] == p) {
                        nextPos = j;
                        break;
                    }
                }

                if (nextPos > fartest) {
                    fartest = nextPos;
                    target = p;
                }
            }

            plug.remove(target);
            plug.add(now);
            ret++;
        }

        System.out.println(ret);
    }
}
