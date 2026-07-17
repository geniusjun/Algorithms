import java.io.*;
import java.util.*;

public class Main {

    static int[][] maps, visited;
    static int T, Y, X, K, ret;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void go(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= Y || nx < 0 || nx >= X || visited[ny][nx] == 1){
                continue;
            }
            if(maps[ny][nx] == 1){
                go(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            maps = new int[Y][X];
            visited = new int[Y][X];
            ret = 0;
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                maps[y][x] = 1;
            }

            for(int i = 0; i < Y; i++){
                for(int j = 0; j < X; j++){
                    if(maps[i][j] == 1 && visited[i][j] == 0){
                        go(i,j);
                        ret++;
                    }
                }
            }

            System.out.println(ret);
        }
    }
}