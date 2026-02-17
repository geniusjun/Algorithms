import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
        Arrays.fill(dist, -1);

        if (soobin == brother) {
            System.out.println(0);
            System.out.println(1);
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
                if (dist[nx] == -1) { // 처음 도달
                    dist[nx] = 1;
                    visited[nx] = visited[front] + 1;
                    queue.add(nx);
                } else { // 이미 도달했었다면 더 빠른 방법인지 확인
                    if (visited[front] + 1 < visited[nx]) { // 이동한 값이 기존에 이동한 값보다 빠르면 초기화
                        visited[nx] = visited[front] + 1;
                        queue.add(nx);
                    } else if (visited[front] + 1 == visited[nx]) { // 같으면 방법 추가
                        dist[nx]++;
                        queue.add(nx);
                    }
                }
            }
        }

        System.out.println(visited[brother] - 1);
        System.out.println(dist[brother]);
    }
}