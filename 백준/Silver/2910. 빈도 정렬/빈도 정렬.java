import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringTokenizer numbers = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>(); // 빈도수를 저장할 map
        List<Integer> list = new ArrayList<>(); // 숫자를 저장할 리스트
        HashMap<Integer, Integer> orderMap = new HashMap<>(); // 순서를 저장할 리스트

        int index = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(numbers.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);

            if (!orderMap.containsKey(num)) {
                orderMap.put(num, index++);
            }
        }

        list.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return orderMap.get(o1) - orderMap.get(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}