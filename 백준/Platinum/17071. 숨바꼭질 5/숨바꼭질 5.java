import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {


    static int maxN = 500000;
    static int[][] visited;
    static int movedBrother;
    static int turn;
    static boolean ok;

    static int[] go(int x) {
        int[] arr = new int[3];
        arr[0] = x + 1;
        arr[1] = x - 1;
        arr[2] = x * 2;
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) { // 같으면 바로 만남
            System.out.println(0);
            return;
        }
        movedBrother = K;
        turn = 1;
        ok = false;
        visited = new int[2][maxN + 4];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[0][N] = 1;
        queue.add(N);
        while (!queue.isEmpty()) {
            movedBrother += turn;
            if (movedBrother > maxN) { // 동생이 최대 이동범위를 넘어가면 break
                break;
            }
            if (visited[turn % 2][movedBrother] != 0) { // 수빈이가 짝홀이 맞게끔 이동했다면 ok~
                ok = true;
                break;
            }
            int qSize = queue.size(); // 현재 턴에 있는 큐의 사이즈를 뽑음. 즉 같은 턴에 있는 애들끼리만 체크
            for (int i = 0; i < qSize; i++) {
                int front = queue.poll();
                int[] moved = go(front);
                for (int j = 0; j < moved.length; j++) {
                    int nx = moved[j];
                    if (nx < 0 || nx > maxN || visited[turn % 2][nx] != 0) {
                        continue;
                    }
                    visited[turn % 2][nx] = visited[(turn + 1) % 2][front] + 1;
                    if (nx == movedBrother) { // 수빈이가 이동한 위치가 동생이 이동한 위차와 같다면 ok~
                        ok = true;
                        break;
                    }
                    queue.add(nx);
                }
                if (ok) {
                    break;
                }
            }
            if (ok) {
                break;
            }
            turn++;
        }

        if (ok) {
            System.out.println(turn);
        } else {
            System.out.println(-1);
        }

    }
}