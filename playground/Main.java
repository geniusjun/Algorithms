import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int answer = 1;
            for(int i = 0; i < f; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            for(int count : map.values()){
                answer *= (count+1);
            }

            answer -= 1;

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}