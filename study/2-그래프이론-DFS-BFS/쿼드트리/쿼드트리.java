import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 쿼드트리 {

    static int N;
    static char[][] arr;
    static StringBuilder sb;

    static void go(int y, int x, int len){

        char c = arr[y][x];

        for(int i = y; i < y + len; i++){
            for(int j = x; j < x + len; j++){
                if(arr[i][j] != c){
                    int half = len / 2;

                    sb.append("(");
                    go(y, x, half);
                    go(y, x + half, half);
                    go(y + half, x, half);
                    go(y + half, x + half, half);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        sb = new StringBuilder();

        go(0,0, N);

        System.out.println(sb);
    }
}