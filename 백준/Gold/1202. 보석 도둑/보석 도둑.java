import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static long N, K, ret;
    static List<Je> jeList;
    static List<Integer> bagList;

    static class Je {
        int weight;
        int price;

        Je(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ret = 0;

        jeList = new ArrayList<>();
        bagList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(line.nextToken());
            int price = Integer.parseInt(line.nextToken());
            jeList.add(new Je(weight, price));
        }

        for (int i = 0; i < K; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }

        jeList.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });

        bagList.sort((o1, o2) -> {
            return o1 - o2;
        });

        int jeCnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < K; i++) {
            while (jeCnt < N && jeList.get(jeCnt).weight <= bagList.get(i)) {
                pq.add(jeList.get(jeCnt).price);
                jeCnt++;
            }
            if (!pq.isEmpty()) {
                ret += pq.poll();
            }
        }
        System.out.println(ret);
    }
}
