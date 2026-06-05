import java.io.*;
import java.util.*;

public class 대칭 차집합 {

    static int A, B, ret;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        ret = 0;
        for(int num : setA){
            if(!setB.contains(num)){
                ret++;
            }
        }

        for(int num : setB){
            if(!setA.contains(num)){
                ret++;
            }
        }


        System.out.println(ret);
    }
}