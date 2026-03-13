import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static List<Integer>[] adjList;
    static int[] visited;

    static int dfs(int idx) {
        int cnt = 1;
        visited[idx] = 1;
        for (int i = 0; i < adjList[idx].size(); i++) {
            int next = adjList[idx].get(i);
            if (visited[next] == 0) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(bf.readLine());
            M = Integer.parseInt(bf.readLine());
            adjList = new ArrayList[N + 1];
            visited = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                adjList[b].add(a);
            }

            if (M != N - 1 || dfs(1) != N) {
                System.out.println("graph");
            } else {
                System.out.println("tree");
            }

        }

    }
}