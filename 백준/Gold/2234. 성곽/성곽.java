import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Y, X, rooms, maxRoom, afterMaxRoom;
    static int[][] maps, visited;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
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
            if ((maps[node.y][node.x] & (1 << i)) == 0) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0) {
                    continue;
                }

                cnt += go(new Node(ny, nx), roomNum);
            }
        }
        return cnt;
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