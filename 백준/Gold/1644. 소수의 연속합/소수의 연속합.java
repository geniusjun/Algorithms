import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, ret;
    static List<Integer> list;
    static int[] visited;

    static void che() {
        visited[0] = 1;
        visited[1] = 1;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (visited[i] == 1) {
                continue;
            }
            for (int j = i * 2; j <= N; j += i) {
                visited[j] = 1;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (visited[i] == 0) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new int[N + 1];
        che();
        ret = 0;
        int l = 0;
        int r = 0;
        int now = 0;
        while (true) {
            if (now < N) {
                if (r == list.size()) {
                    break;
                }
                now += list.get(r);
                r++;
            } else if (now >= N) {
                now -= list.get(l);
                l++;
            }

            if (now == N) {
                ret++;
            }
        }

        System.out.println(ret);

    }
}
