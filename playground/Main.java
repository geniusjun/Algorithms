import java.util.*;
import java.io.*;

public class Main{

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int M, N, K, ret, cnt;
    static int[][] arr, visited;
    static List<Integer> list;

    static void go(int y, int x){
        cnt++;
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= M || nx >= N || visited[ny][nx] != 0 || arr[ny][nx] != 0){
                continue;
            }

            go(ny,nx);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new int[M][N];

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int i = ly; i < ry; i++){
                for(int j = lx; j < rx; j++){
                    arr[i][j] = 1;
                }
            }
        }

        ret = 0;
        list = new ArrayList<>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 0 && visited[i][j] == 0){
                    cnt = 0;
                    ret++;
                    go(i, j);
                    list.add(cnt);
                }
            }
        }

        list.sort((o1, o2) ->{
            return o1 - o2;
        });
        System.out.println(ret);
        for(int i : list){
            System.out.print(i + " ");
        }

    }
}