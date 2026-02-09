import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adjList;
    static int[] visited;

    static int DFS(int find) {
        visited[find] = 1;
        int count = 1;
        for (int i = 0; i < adjList[find].size(); i++) {
            if (visited[adjList[find].get(i)] == 1) {
                continue;
            }
            count += DFS(adjList[find].get(i));
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            int child = Integer.parseInt(line.nextToken());
            int parent = Integer.parseInt(line.nextToken());
            adjList[parent].add(child);
        }
        visited = new int[N + 1];
        List<Integer> ret = new ArrayList<>();
        int nowComputer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            int findComputer = DFS(i);
            if (nowComputer < findComputer) {
                nowComputer = findComputer;
                ret = new ArrayList<>();
                ret.add(i);
            } else if (nowComputer == findComputer) {
                ret.add(i);
            }
        }
        Collections.sort(ret);
        for (int i = 0; i < ret.size(); i++) {
            System.out.print(ret.get(i) + " ");
        }
    }

}