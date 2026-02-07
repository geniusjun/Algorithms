import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = bf.readLine();
            if (input.equals(".")) {
                break;
            }
            Stack<String> stack = new Stack<>();
            String[] splited = input.split("");
            for (int i = 0; i < splited.length; i++) {
                if (stack.isEmpty()) {
                    if (splited[i].equals("(") || splited[i].equals("[") || splited[i].equals(")") || splited[i].equals(
                            "]")) {
                        stack.push(splited[i]);
                    }
                } else if (splited[i].equals("(") || splited[i].equals("[")) {
                    stack.push(splited[i]);
                } else if (splited[i].equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(splited[i]);
                    }
                } else if (splited[i].equals("]")) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(splited[i]);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}