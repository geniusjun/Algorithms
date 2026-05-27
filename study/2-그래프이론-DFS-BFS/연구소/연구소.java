import java.io.*;
import java.util.*;

public class 연구소 {

    static int Y, X, ret;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0 ,-1};
    static int[][] maps, nMaps, visited;

    static void wall(int start, int cnt){
        if(cnt == 3){
            // 맵 복사해서 바이러스 확산
            nMaps = makeMaps(maps);
            visited = new int[Y][X];
            for(int i = 0; i < Y; i++){
                for(int j = 0; j < X; j++){
                    if(nMaps[i][j] == 2 && visited[i][j] == 0){
                        go(i, j);
                    }
                }
            }
            ret = Math.max(ret, countSafe());

            return;
        }

        for(int idx = start; idx < Y * X; idx++) {
            int y = idx / X;
            int x = idx % X;

            if (maps[y][x] == 0) {
                maps[y][x] = 1;
                wall(idx + 1, cnt + 1);
                maps[y][x] = 0;
            }
        }
    }

    static int[][] makeMaps(int[][] maps){
        int[][] nMaps = new int[Y][X];
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                nMaps[i][j] = maps[i][j];
            }
        }
        return nMaps;
    }


    static void go(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= Y || nx >= X || nMaps[ny][nx] == 1 || nMaps[ny][nx] == 2 || visited[ny][nx] == 1){
                continue;
            }
            nMaps[ny][nx] = 1;
            go(ny, nx);
        }
    }

    static int countSafe(){
        int cnt = 0;
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                if(nMaps[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }


    // 벽 세우기
    // 바이러스 퍼뜨리기
    // 안전 영역 최신화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];

        for(int i = 0; i < Y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < X; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 0;
        // 벽 세우기
        wall(0,0);

        System.out.println(ret);


    }
}