import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미로 탐색 {

    static int Y, X, ret;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr, visited;

    static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[Y][X];
        visited = new int[Y][X];

        for(int i = 0; i < Y; i++){
            String input = br.readLine();
            for(int j = 0; j < X; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Node front = queue.pollFirst();
            for(int i = 0; i < 4; i++){
                int ny = front.y + dy[i];
                int nx = front.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= Y || nx >= X || arr[ny][nx] == 0 || visited[ny][nx] != 0){
                    continue;
                }

                visited[ny][nx] = visited[front.y][front.x] + 1;
                queue.addLast(new Node(ny, nx));
            }
        }

        System.out.println(visited[Y - 1][X- 1]);
    }
}