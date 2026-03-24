import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long ret;
    static int[] arr, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // 수열 담기용
        cnt = new int[N + 1]; // 중복 체크용
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ret = 0;
        int l = 0;
        for (int r = 0; r < N; r++) {
            cnt[arr[r]]++;

            while (cnt[arr[r]] > 1) {
                cnt[arr[l]]--;
                l++;
            }

            ret += (r - l + 1);
        }

        System.out.println(ret);

    }
}
