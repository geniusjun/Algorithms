import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 기상캐스터 {

    static int Y, X;
    static int[][] arr;

    static void go(int y, int x){
        if(x == X - 1 || arr[y][x + 1] != -1){
            return;
        }
        if(arr[y][x + 1] == -1){
            arr[y][x + 1] = arr[y][x] + 1;
            go(y , x + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[Y][X];

        for(int i = 0; i < Y; i++){
            String input = br.readLine();
            for(int j = 0; j < X; j++){
                char c = input.charAt(j);
                if(c == '.') {
                    arr[i][j] = -1;
                } else{
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X - 1; j++){
                if(arr[i][j] == 0){
                    go(i, j);
                }
            }
        }

        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}