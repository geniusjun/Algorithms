import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int Y;
    static int X;
    static char[][] maps;
    static int ret;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    static void go(Set<Character> set, int idx, Node here) {
        ret = Math.max(idx, ret);

        set.add(maps[here.y][here.x]);

        for (int i = 0; i < 4; i++) {
            int ny = here.y + dy[i];
            int nx = here.x + dx[i];
            if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                continue;
            }
            if (!set.contains(maps[ny][nx])) {
                go(set, idx + 1, new Node(ny, nx));
            }
        }
        set.remove(maps[here.y][here.x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        maps = new char[Y][X];
        Set<Character> visitSet = new HashSet<>();

        for (int i = 0; i < Y; i++) {
            String line = bf.readLine();
            for (int j = 0; j < X; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        go(visitSet, 1, new Node(0, 0));
        System.out.println(ret);
    }
}