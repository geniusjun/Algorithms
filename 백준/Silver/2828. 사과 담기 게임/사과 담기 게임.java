import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(bf.readLine());
        int bucketStartPos = 1;
        int ret = 0;
        for (int i = 0; i < J; i++) {
            int position = Integer.parseInt(bf.readLine());
            if (position < bucketStartPos) {
                while (position < bucketStartPos) {
                    bucketStartPos--;
                    M--;
                    ret++;
                }
            } else if (position > M) {
                while (position > M) {
                    bucketStartPos++;
                    M++;
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}