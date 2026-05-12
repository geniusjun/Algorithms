import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            int num = Integer.parseInt(line);
            int cnt = 1;
            int ret = 1;
            while(true){
                if(cnt % num == 0){
                    System.out.println(ret);
                    break;
                } else{
                    cnt = (cnt * 10 + 1) % num;
                    ret++;
                }
            }
        }
    }
}