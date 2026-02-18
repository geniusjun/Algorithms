import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = bf.readLine().split(" ");
            if (inputs[1].equals("enter")) {
                set.add(inputs[0]);
            } else {
                set.remove(inputs[0]);
            }
        }

        List<String> names = new ArrayList<>(set);
        names.sort(Collections.reverseOrder());
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }
}