import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else { parent[rb] = ra; rank[ra]++; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) { parent[i] = i; }

        // 인접행렬 입력받아 연결된 도시들 union
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) union(i, j);
            }
        }

        // 여행 계획
        int[] plan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 도시의 루트와 모두 같은지 확인
        int root = find(plan[0]);
        boolean ok = true;
        for (int i = 1; i < M; i++) {
            if (find(plan[i]) != root) { ok = false; break; }
        }

        System.out.println(ok ? "YES" : "NO");
    }
}
