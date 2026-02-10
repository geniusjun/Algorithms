import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        StringTokenizer line = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(line.nextToken()));
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);

        System.out.println(list.get(k - 1));
    }


}