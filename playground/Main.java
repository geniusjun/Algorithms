import java.io.*;
import java.util.*;

public class Main {

    static int Y, X, cnt, cheese, bCheese;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] maps, visited;

    static void go(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= Y || nx >= X){
                continue;
            }
            if(visited[ny][nx] == 0){
                if(maps[ny][nx] == 1){
                    maps[ny][nx] = 0;
                    visited[ny][nx] = 1;
                    cheese++;
                } else{
                    go(ny,nx);
                }
            }
        }
    }

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

        cnt = 0;
        // 치즈 한번 녹이며 갯수 가져오기
        // 개수가 0이면 마무리
        while(true){
            visited = new int[Y][X];
            cheese = 0;
            go(0,0);
            if(cheese == 0) {
                break;
            }
            cnt++;
            bCheese = cheese;
        }

        System.out.println(cnt);
        System.out.println(bCheese);
    }
}