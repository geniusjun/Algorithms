import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int X, ret;
    static List<Integer> list;

    static void go(int sum, List<Integer> list) {
        if (sum < X) {
            return;
        }
        if (sum == X) {
            ret = list.size();
            return;
        }

        int shortestHalf = list.get(list.size() - 1) / 2;
        if (sum - shortestHalf >= X) { // 버리고
            list.remove(list.size() - 1);
            list.add(shortestHalf);
            go(sum - shortestHalf, list);
        } else { // 안버리고
            list.remove(list.size() - 1);
            list.add(shortestHalf);
            list.add(shortestHalf);
            go(sum, list);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();
        list.add(64);
        go(64, list);

        System.out.println(ret);
    }
}