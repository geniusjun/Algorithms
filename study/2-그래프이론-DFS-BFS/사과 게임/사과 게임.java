import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사과 게임 {

    static int N, M, J, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());
        int bucketStart = 0;
        ret = 0;

        for(int i = 0; i < J; i++){
            int here = Integer.parseInt(br.readLine()) - 1;
            if(bucketStart + M - 1 < here){
                int gap = here - (bucketStart + M - 1);
                ret += gap;
                bucketStart += gap;
            } else if(bucketStart > here){
                int gap = bucketStart - here;
                ret += gap;
                bucketStart -= gap;
            }
        }
        System.out.println(ret);
    }
}