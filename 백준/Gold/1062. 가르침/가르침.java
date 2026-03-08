import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] words;
    static String s;

    static int count(int mask) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int word = words[i];
            if (word != 0 && (word & mask) == word) {
                cnt++;
            }
        }
        return cnt;
    }

    static int go(int idx, int k, int mask) {
        if (k < 0) {
            return 0;
        }
        if (idx == 26) {
            return count(mask);
        }
        int ret = go(idx + 1, k - 1, mask | (1 << idx));
        if (idx != 'a' - 'a' && idx != 'n' - 'a' && idx != 't' - 'a' && idx != 'i' - 'a' && idx != 'c' - 'a') {
            ret = Math.max(ret, go(idx + 1, k, mask));
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        words = new int[51];
        for (int i = 0; i < N; i++) {
            s = bf.readLine();
            for (int j = 0; j < s.length(); j++) {
                words[i] |= (1 << s.charAt(j) - 'a');
            }
        }
        System.out.println(go(0, M, 0));
    }
}