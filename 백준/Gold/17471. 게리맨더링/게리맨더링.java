import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, ret;
    static Node[] people;
    static List<Integer>[] adjList;

    static class Node {
        int weight;
        int election;

        Node(int weight, int election) {
            this.weight = weight;
            this.election = election;
        }
    }

    static void go(int idx) {
        if (idx == N) {
            if (isOkay()) {
                int one = 0;
                int two = 0;
                for (int i = 1; i <= N; i++) {
                    if (people[i].election == 1) {
                        one += people[i].weight;
                    } else {
                        two += people[i].weight;
                    }
                }
                ret = Integer.min(ret, Math.abs(one - two));
            }
            return;
        }

        people[idx + 1].election = 1;
        go(idx + 1);
        people[idx + 1].election = 2;
        go(idx + 1);
    }

    static boolean isOkay() {
        int[] visited = new int[N + 4];
        int cnt1 = 0, cnt2 = 0;
        int start1 = -1, start2 = -1;
        for (int i = 1; i <= N; i++) {
            if (people[i].election == 1) {
                cnt1++;
                if (start1 == -1) {
                    start1 = i;
                }
            } else {
                cnt2++;
                if (start2 == -1) {
                    start2 = i;
                }
            }
        }

        if (cnt1 == 0 || cnt2 == 0) {
            return false;
        }

        int v1 = find(start1, visited, 1);
        if (v1 != cnt1) {
            return false;
        }

        int v2 = find(start2, visited, 2);
        if (v2 != cnt2) {
            return false;
        }
        return true;
    }

    static int find(int idx, int[] visited, int group) {
        visited[idx] = 1;
        int cnt = 1;
        for (int i = 0; i < adjList[idx].size(); i++) {
            int next = adjList[idx].get(i);
            if (visited[next] != 0 || people[next].election != group) {
                continue;
            }
            cnt += find(next, visited, group);
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        people = new Node[N + 4];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = new Node(Integer.parseInt(st.nextToken()), 0);
        }
        adjList = new ArrayList[N + 4];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(line.nextToken());
            for (int j = 0; j < size; j++) {
                adjList[i].add(Integer.parseInt(line.nextToken()));
            }
        }

        ret = Integer.MAX_VALUE;
        go(0);
        if (ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ret);
        }
    }
}