import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 영역 구하기 {

    static int Y, X, K, ret;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    static int go(int y, int x){
        visited[y][x] = 1;
        int cnt = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0){
                continue;
            }
            cnt += go(ny, nx);
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[Y][X];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++){
                for(int k = x1; k < x2; k++){
                    visited[j][k] = 1;
                }
            }
        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                if(visited[i][j] == 0){
                    list.add(go(i,j));
                    cnt++;
                }
            }
        }

        list.sort((o1, o2) ->{
            return o1 - o2;
        });

        System.out.println(cnt);
        for(Integer num : list){
            System.out.print(num + " ");
        }
    }
}