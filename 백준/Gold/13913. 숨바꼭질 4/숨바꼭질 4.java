import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static int[] visited;

    static int[] go(int x) {
        int[] arr = new int[3];
        arr[0] = x + 1;
        arr[1] = x - 1;
        arr[2] = 2 * x;

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int soobin = Integer.parseInt(st.nextToken());
        int brother = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        visited = new int[100001];
        if (soobin == brother) {
            System.out.println(0);
            System.out.println(soobin);
            return;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[soobin] = 1;
        queue.add(soobin);

        while (!queue.isEmpty()) {
            int front = queue.poll();
            int[] goX = go(front);
            for (int i = 0; i < goX.length; i++) {
                int nx = goX[i];
                if (nx < 0 || nx > 100000) {
                    continue;
                }

                if (visited[nx] == 0) {
                    visited[nx] = visited[front] + 1;
                    dist[nx] = front;
                    queue.add(nx);
                }
            }
        }
        List<Integer> retList = new ArrayList<>();
        for (int i = brother; i != soobin; i = dist[i]) {
            retList.add(i);
        }
        retList.add(soobin);

        System.out.println(visited[brother] - 1);
        Collections.reverse(retList);
        for (int i = 0; i < retList.size(); i++) {
            System.out.print(retList.get(i) + " ");
        }
    }
}