import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long N;

    static class Cow {
        int arrive;
        int check;

        Cow(int arrive, int check) {
            this.arrive = arrive;
            this.check = check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ret = 0;
        List<Cow> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            list.add(new Cow(arrive, check));
        }

        list.sort((o1, o2) -> {
            return o1.arrive - o2.arrive;
        });

        int l = list.get(0).arrive;
        int r = l + list.get(0).check;
        for (int i = 1; i < list.size(); i++) {
            if (r <= list.get(i).arrive) {
                l = list.get(i).arrive;
                r = l + list.get(i).check;
            } else {
                l = r;
                r = l + list.get(i).check;
            }
        }

        System.out.println(0 + r);
    }
}
