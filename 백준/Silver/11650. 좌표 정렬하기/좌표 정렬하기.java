import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static class Node {
        int y;
        int x;

        Node(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i).x).append(" ").append(list.get(i).y);
            System.out.println(sb);
        }
    }
}