import java.util.*;
import java.io.*;

public class 미로 탐색2 {

    static int Y, X;
    static int[][] maps, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        maps = new int[Y][X];
        visited = new int[Y][X];

        for(int i = 0; i < Y; i++){
            String input = br.readLine();
            for(int j = 0; j < X; j++){
                maps[i][j] = input.charAt(j) - '0';
            }
        }

        visited[0][0] = 1;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(0,0));
        while (!deque.isEmpty()) {
            Node front = deque.pollFirst();
            for(int i = 0; i < 4; i++){
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= Y || nx >= X){
                    continue;
                }

                if(maps[ny][nx] == 0 || visited[ny][nx] != 0){
                    continue;
                }

                visited[ny][nx] = visited[front.y][front.x] + 1;
                deque.addLast(new Node(ny, nx));
            }
        }

        System.out.println(visited[Y - 1][X - 1]);

    }

}