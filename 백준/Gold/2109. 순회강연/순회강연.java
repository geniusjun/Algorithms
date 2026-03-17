import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Lecture {
        int day;
        int price;

        Lecture(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Lecture(day, price));
        }

        list.sort((o1, o2) -> {
            return o1.day - o2.day;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(list.get(i).price);
            if (pq.size() > list.get(i).day) {
                pq.poll();
            }
        }
        int ret = 0;
        while (!pq.isEmpty()) {
            ret += pq.poll();
        }

        System.out.println(ret);
    }
}
