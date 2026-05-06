import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 포켓몬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        for(int i = 0; i < M; i++){
            String input = br.readLine();
            try{
                int key = Integer.parseInt(input);
                System.out.println(numMap.get(key));
            } catch(Exception e){
                System.out.println(nameMap.get(input));
            }
        }
    }
}