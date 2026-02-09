import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adjList;
    static int delete;

    static int DFS(int find) {
        int ret = 0;
        int child = 0;
        for (int i = 0; i < adjList[find].size(); i++) {
            if (adjList[find].get(i) == delete) {
                continue;
            }
            child++;
            ret += DFS(adjList[find].get(i));
        }

        if (child == 0) {
            return 1;
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) {
                root = i;
            } else {
                adjList[num].add(i);
            }
        }

        delete = Integer.parseInt(bf.readLine());
        if (delete == root) {
            System.out.println("0");
        } else {
            System.out.println(DFS(root));
        }


    }

}