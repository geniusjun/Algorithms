import java.io.*;
import java.util.*;

public class 암기왕 {

    static int T, N, M;
    static Set<Integer> noteSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            noteSet = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                noteSet.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(st.nextToken());
                if(noteSet.contains(num)){
                    sb.append(1).append('\n');
                } else{
                    sb.append(0).append('\n');
                }
            }
            System.out.print(sb);
        }

    }
}