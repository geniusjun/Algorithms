import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, rooms, maxRoom, afterMaxRoom;
    static int[][] maps, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] roomCosts; // Connected Component 저장값

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int go(Node node, int roomNum) {
        visited[node.y][node.x] = roomNum;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int ny = node.y + dy[i];
            int nx = node.x + dx[i];
            if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0 || isWall(maps[node.y][node.x], dy[i],
                    dx[i])) {
                continue;
            }

            cnt += go(new Node(ny, nx), roomNum);
        }
        return cnt;
    }


    static boolean isWall(int wall, int dy, int dx) {
        if (dx == -1 && ((wall & (1 << 0)) != 0)) { // 서쪽으로 가려는데 벽이면 못감
            return true;
        }
        if (dy == -1 && ((wall & (1 << 1)) != 0)) { // 북쪽으로 가려는데 벽이면 못감
            return true;
        }
        if (dx == 1 && ((wall & (1 << 2)) != 0)) { // 동쪽으로 가려는데 벽이면 못감
            return true;
        }
        if (dy == 1 && ((wall & (1 << 3)) != 0)) { // 남쪽으로 가려는데 벽이면 못감
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];
        visited = new int[Y][X];

        rooms = 0;
        maxRoom = 0;
        afterMaxRoom = 0;

        for (int i = 0; i < Y; i++) {
            StringTokenizer walls = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                maps[i][j] = Integer.parseInt(walls.nextToken());
            }
        }

        roomCosts = new int[Y * X + 4];
        int roomNum = 1;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (visited[i][j] == 0) {
                    int roomSize = go(new Node(i, j), roomNum);
                    maxRoom = Math.max(roomSize, maxRoom);
                    roomCosts[roomNum] = roomSize;
                    rooms++;
                    roomNum++;
                }
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (i + 1 < Y) {
                    int up = visited[i][j];
                    int down = visited[i + 1][j];

                    if (up != down) {
                        afterMaxRoom = Math.max(afterMaxRoom, roomCosts[up] + roomCosts[down]);
                    }
                }
                if (j + 1 < X) {
                    int left = visited[i][j];
                    int right = visited[i][j + 1];

                    if (left != right) {
                        afterMaxRoom = Math.max(afterMaxRoom, roomCosts[left] + roomCosts[right]);
                    }
                }
            }
        }

        System.out.println(rooms);
        System.out.println(maxRoom);
        System.out.println(afterMaxRoom);


    }
}