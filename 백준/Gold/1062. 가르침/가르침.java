import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, K, ret;
    static Set<Character> set;
    static List<String> words;

    static void go(Set<Character> set, int idx) {
        if (set.size() == K) {
            if (!set.contains('a') || !set.contains('n') || !set.contains('t') || !set.contains('i') || !set.contains(
                    'c')) {
                return;
            }

            ret = Math.max(ret, readWord(set));
            return;
        }

        for (int i = idx; i < 26; i++) {
            set.add((char) (i + 97));
            go(set, i + 1);
            set.remove((char) (i + 97));
        }
    }

    static int readWord(Set<Character> set) {
        int cnt = 0;

        for (int i = 0; i < words.size(); i++) {
            boolean isContain = true;
            for (int j = 0; j < words.get(i).length(); j++) {
                if (!set.contains(words.get(i).charAt(j))) {
                    isContain = false;
                    break;
                }
            }
            if (isContain) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 0~25

        words = new ArrayList<>();
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(bf.readLine());
        }

        ret = 0;

        go(set, 0);

        System.out.println(ret);
    }
}