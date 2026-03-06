import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] words = new int[51];

    static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            if (word != 0 && (word & mask) == word) {
                cnt++;
            }
        }
        return cnt;
    }

    static int go(int index, int k, int mask) {

        if (k < 0) return 0;

        if (index == 26) {
            return count(mask);
        }

        int ret = go(index + 1, k - 1, mask | (1 << index));

        if (index != ('a' - 'a') &&
            index != ('n' - 'a') &&
            index != ('t' - 'a') &&
            index != ('i' - 'a') &&
            index != ('c' - 'a')) {

            ret = Math.max(ret, go(index + 1, k, mask));
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        System.out.println(go(0, m, 0));
    }
}