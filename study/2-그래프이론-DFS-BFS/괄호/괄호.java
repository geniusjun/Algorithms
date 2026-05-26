import java.io.*;
import java.util.*;

public class 괄호 {

    static int T;
    static ArrayDeque<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String input = br.readLine();
            stack = new ArrayDeque<>();

            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if (stack.isEmpty()) {
                    if(c == ')'){
                        stack.addLast(c);
                        break;
                    } else{
                        stack.addLast(c);
                    }
                } else{
                    if (c == ')') {
                        if(stack.peekLast() == '('){
                            stack.pollLast();
                        } else{
                            break;
                        }
                    } else{
                        stack.addLast(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }

    }
}