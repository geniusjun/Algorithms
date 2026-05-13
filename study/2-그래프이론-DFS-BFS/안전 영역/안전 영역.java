import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 안전 영역 {

    static int T, ret, mxHeight;
    static int[][] arr, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void go(int y, int x, int h){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= T || nx >= T || visited[ny][nx] != 0 || arr[ny][nx] <= h){
                continue;
            }
            go(ny, nx, h);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        arr = new int[T][T];

        mxHeight = 0;
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < T; j++){
                int height = Integer.parseInt(st.nextToken());
                mxHeight = Math.max(height, mxHeight);
                arr[i][j] = height;
            }
        }

        ret = 0;
        for(int i = 0; i < mxHeight; i++){
            visited = new int[T][T];
            int hereRet = 0;
            for(int j = 0; j < T; j++){
                for(int k = 0; k < T; k++){
                    if(visited[j][k] == 0 && arr[j][k] > i){
                        hereRet++;
                        go(j, k, i);
                    }
                }
            }
            ret = Math.max(ret, hereRet);
        }

        System.out.println(ret);
    }
}