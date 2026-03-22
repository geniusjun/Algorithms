import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }

            else if (cmd == 2) {
                if (stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');
            }

            else if (cmd == 3) {
                sb.append(stack.size()).append('\n');
            }

            else if (cmd == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            }

            else if (cmd == 5) {
                if (stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.peek()).append('\n');
            }
        }

        System.out.print(sb);
    }
}