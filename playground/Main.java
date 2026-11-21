import java.util.*;
import java.io.*;

public class Main {

    static int n, ret;
    static ArrayDeque<Character> deque;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        while(n-- >0){
            String input = br.readLine();
            deque = new ArrayDeque<>();

            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(deque.isEmpty()){
                    deque.addLast(c);
                    continue;
                }
                if(deque.peekLast() == c){
                    deque.pollLast();
                } else{
                    deque.addLast(c);
                }
            }

            if (deque.isEmpty()) {
                ret++;
            }
        }

        System.out.println(ret);

    }

}