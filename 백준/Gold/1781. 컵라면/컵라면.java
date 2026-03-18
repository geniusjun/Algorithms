import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Problem> list;

    static class Problem {
        int deadLine;
        int ramen;

        Problem(int deadLine, int ramen) {
            this.deadLine = deadLine;
            this.ramen = ramen;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            list.add(new Problem(deadLine, ramen));
        }

        list.sort((o1, o2) -> {
            return o1.deadLine - o2.deadLine;
        });

        PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.ramen - o2.ramen;
        });

        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i));
            while (pq.size() > list.get(i).deadLine) {
                pq.poll();
            }
        }

        int ret = 0;
        while (!pq.isEmpty()) {
            ret += pq.poll().ramen;
        }

        System.out.println(ret);
    }
}
