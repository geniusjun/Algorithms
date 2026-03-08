import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ret;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(bf.readLine());
        }
        ret = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(bf.readLine())) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}