import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static List<Integer>[] adjList;
    static boolean isGraph;
    static Set<Integer> set;

    static int dfs(int idx) {
        if (set.contains(idx)) {
            return 0;
        }
        int cnt = 1;
        set.add(idx);

        for (int i = 0; i < adjList[idx].size(); i++) {
            int next = adjList[idx].get(i);
            cnt += dfs(next);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            isGraph = false;
            N = Integer.parseInt(bf.readLine());
            M = Integer.parseInt(bf.readLine());
            adjList = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                for (int j = 0; j < adjList[a].size(); j++) {
                    if (adjList[a].get(j) == b) {
                        isGraph = true;
                        break;
                    }
                }
                for (int j = 0; j < adjList[b].size(); j++) {
                    if (adjList[b].get(j) == a) {
                        isGraph = true;
                        break;
                    }
                }

                adjList[a].add(b);
                adjList[b].add(a);
            }

            set = new HashSet<>();
            if (dfs(1) != N) {
                isGraph = true;
            }

            if (M != N - 1) {
                isGraph = true;
            }
            if (isGraph) {
                System.out.println("graph");
            } else {
                System.out.println("tree");
            }

        }

    }
}