
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int N;
    static List<String> list;
    static Set<String> set;


    static void go(int[][] ways) {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            if (!set.contains(input)) {
                list.add(input);
            }
            set.add(input);
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}