import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static Set<Integer> set;
    static StringBuilder sb;

    static void add(int x) {
        set.add(x);
    }

    static void remove(int x) {
        set.remove(x);
    }

    static void check(int x) {
        if (set.contains(x)) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    static void all() {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    static void empty() {
        set.clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bf.readLine());
        set = new HashSet<>();
        sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String oper = st.nextToken();
            if (oper.equals("all")) {
                all();
                continue;
            }
            if (oper.equals("empty")) {
                empty();
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            if (oper.equals("add")) {
                add(x);
            } else if (oper.equals("remove")) {
                remove(x);
            } else if (oper.equals("check")) {
                check(x);
            } else if (oper.equals("toggle")) {
                toggle(x);
            }
        }

        System.out.println(sb);
    }
}