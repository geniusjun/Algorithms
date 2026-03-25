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

            // 꽃혀있으면 넘어가기
            if (plug.contains(now)) {
                continue;
            }

            // 콘센트 비어 있으면 꽃기
            if (plug.size() < N) {
                plug.add(now);
                continue;
            }

            // 꽉 찼을때 하나 뺴야함.
            int target = -1; // 뽑을놈
            int pos = -1;

            for (int p : plug) {
                int nextUse = Integer.MAX_VALUE;

                // 뽑혀있는 애들중 다음에 나오는 것들 찾기
                for (int j = i + 1; j < K; j++) {
                    if (arr[j] == p) {
                        nextUse = j;
                        break;
                    }
                }

                // 뽑혀있는 애들중 다음에 나오는 것중 가장 뒤에 있는 것 뽑자 -> Optimal Page Replacement
                if (nextUse > pos) {
                    pos = nextUse;
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
