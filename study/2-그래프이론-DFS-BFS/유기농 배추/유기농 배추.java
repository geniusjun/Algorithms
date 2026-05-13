import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 유기농 배추 {

    static int T, Y, X, K, ret;
    static int[][] arr, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= Y || nx >= X || visited[ny][nx] != 0 || arr[ny][nx] == 0){
                continue;
            }
            dfs(ny, nx);
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
            ret = 0;
            arr = new int[Y][X];
            visited = new int[Y][X];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for(int i = 0; i < Y; i++){
                for(int j = 0; j < X; j++){
                    if(arr[i][j] == 1 && visited[i][j] == 0){
                        dfs(i, j);
                        ret++;
                    }
                }
            }

            System.out.println(ret);
        }
    }
}