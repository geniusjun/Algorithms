import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static class Node {
        int weight;
        int realIdx;
        int prime;

        Node(int weight, int realIdx, int prime) {
            this.weight = weight;
            this.realIdx = realIdx;
            this.prime = prime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        List<Node> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Node(Integer.parseInt(st.nextToken()), i, 0));
        }

        list.sort((o1, o2) -> {
            return o1.weight - o2.weight;
        });

        int cnt = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).prime = cnt;
            if (list.get(i).weight < list.get(i + 1).weight) {
                cnt++;
            }
        }
        list.get(list.size() - 1).prime = cnt;

        list.sort((o1, o2) -> {
            return o1.realIdx - o2.realIdx;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).prime).append(" ");
        }

        System.out.println(sb);
    }
}