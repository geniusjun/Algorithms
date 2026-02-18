
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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

        String[] names = set.toArray(new String[0]);
        Arrays.sort(names, Collections.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}