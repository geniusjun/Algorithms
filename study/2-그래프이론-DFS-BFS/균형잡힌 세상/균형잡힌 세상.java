import java.io.*;
import java.util.*;

public class 균형잡힌 세상 {

    static String input;
    static ArrayDeque<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new ArrayDeque<>();
        while(true){
            input = br.readLine();
            if(input.equals(".")){
                break;
            }
            stack.clear();
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if (stack.isEmpty()) {
                    if(c == ')' || c == ']'){
                        stack.addLast(c);
                        break;
                    } else if(c == '(' || c == '['){
                        stack.addLast(c);
                    }
                } else{
                    if(c == ')') {
                        if (stack.peekLast() == '(') {
                            stack.pollLast();
                        }
                    }
                    else if(c == ']'){
                        if(stack.peekLast() == '['){
                            stack.pollLast();
                        }
                    }
                    else if(c == '(' || c == '['){
                        stack.addLast(c);
                    }
                }
            }

            if(stack.isEmpty()){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }
        }


    }
}