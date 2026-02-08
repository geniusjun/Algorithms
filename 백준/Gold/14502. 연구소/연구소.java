import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] maps;
    static int[][] dMaps;
    static int[][] visited;

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void DFS(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length || visited[ny][nx] == 1
                    || dMaps[ny][nx] == 1) {
                continue;
            }

            if (dMaps[ny][nx] == 0) {
                dMaps[ny][nx] = 2;
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];
        visited = new int[Y][X];
        List<Node> blankList = new ArrayList<>();
        for (int i = 0; i < Y; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                int resource = Integer.parseInt(line.nextToken());
                if (resource == 0) {
                    blankList.add(new Node(i, j));
                }
                maps[i][j] = resource;
            }
        }
        int cnt = 0;
        int safe = Integer.MIN_VALUE;
        while (cnt <= blankList.size()) {
            dMaps = new int[Y][X];
            for (int e = 0; e < Y; e++) {
                for (int r = 0; r < X; r++) {
                    dMaps[e][r] = maps[e][r];
                }
            }
            for (int i = cnt + 1; i < blankList.size(); i++) {
                for (int j = i + 1; j < blankList.size(); j++) {
                    dMaps[blankList.get(cnt).y][blankList.get(cnt).x] = 1;
                    dMaps[blankList.get(i).y][blankList.get(i).x] = 1;
                    dMaps[blankList.get(j).y][blankList.get(j).x] = 1;
                    for (int k = 0; k < Y; k++) {
                        for (int l = 0; l < X; l++) {
                            if (dMaps[k][l] == 2 && visited[k][l] == 0) {
                                DFS(k, l);
                            }
                        }
                    }
                    int zeroCnt = 0;
                    for (int q = 0; q < Y; q++) {
                        for (int w = 0; w < X; w++) {
                            if (dMaps[q][w] == 0) {
                                zeroCnt++;
                            }
                        }
                    }
                    safe = Math.max(zeroCnt, safe);
                    dMaps = new int[Y][X];
                    for (int e = 0; e < Y; e++) {
                        for (int r = 0; r < X; r++) {
                            dMaps[e][r] = maps[e][r];
                        }
                    }
                    visited = new int[Y][X];
                }
            }
            cnt++;
        }

        System.out.println(safe);
    }

}