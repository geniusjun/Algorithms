import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int[][] computer;

    private static void dfs(int now) {
        visited[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        computer = computers;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        return cnt;
    }
}