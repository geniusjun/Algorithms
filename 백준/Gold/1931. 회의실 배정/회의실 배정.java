import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Re> list;

    static class Re {
        int l;
        int r;

        Re(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Re(l, r));
        }

        list.sort((o1, o2) -> {
            if (o1.r == o2.r) {
                return o1.l - o2.l;
            } else {
                return o1.r - o2.r;
            }
        });

        int l = list.get(0).l;
        int r = list.get(0).r;
        int ret = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).l >= r) {
                ret++;
                l = list.get(i).l;
                r = list.get(i).r;
            }

        }

        System.out.println(ret);
    }
}
