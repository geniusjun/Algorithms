
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();
            String[] words = bf.readLine().split("");
            stack.push(words[0]);
            for (int j = 1; j < words.length; j++) {
                if (!stack.isEmpty() && stack.peek().equals(words[j])) {
                    stack.pop();
                } else {
                    stack.push(words[j]);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}