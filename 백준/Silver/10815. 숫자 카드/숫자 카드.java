import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(bf.readLine());
        StringTokenizer line = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(line.nextToken());
            if (set.contains(num)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}