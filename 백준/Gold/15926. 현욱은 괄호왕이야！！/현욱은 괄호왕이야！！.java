import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        String input = bf.readLine();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else { // ')'
                stack.pop();
                if (!stack.isEmpty()) {
                    ret = Math.max(ret, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        System.out.println(ret);
    }

}