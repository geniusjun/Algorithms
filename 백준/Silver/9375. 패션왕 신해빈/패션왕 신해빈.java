import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int test = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < test; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }
            int result = 1;
            for (Integer value : map.values()) {
                result *= (value + 1);
            }
            System.out.println(--result);
        }
    }
}