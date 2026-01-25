import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> numberMap = new HashMap<>();
        HashMap<String, Integer> stringMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = bf.readLine();
            numberMap.put(i, name);
            stringMap.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String input = bf.readLine();
            if (input.charAt(0) - 0 >= 65) {
                System.out.println(stringMap.get(input));
            } else {
                System.out.println(numberMap.get(Integer.parseInt(input)));
            }
        }
    }
}