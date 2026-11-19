import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> sMap = new HashMap<>();
        Map<Integer, String> nMap = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            sMap.put(input, i);
            nMap.put(i, input);
        }

        for(int i = 0; i < M; i++){
            String input = br.readLine();
            try{
                int idx = Integer.parseInt(input);
                System.out.println(nMap.get(idx));
            } catch(Exception e){
                System.out.println(sMap.get(input));
            }
        }

    }
}