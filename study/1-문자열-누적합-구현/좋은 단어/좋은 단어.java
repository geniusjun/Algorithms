import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좋은 단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ret = 0;
        while(N-- > 0) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            String word = br.readLine();

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!stack.isEmpty()){
                    if(stack.peekLast() == c){
                        stack.pollLast();
                    } else{
                        stack.addLast(c);
                    }
                } else{
                    stack.addLast(c);
                }
            }

            if (stack.isEmpty()) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}