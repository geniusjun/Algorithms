import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split("");
            ArrayDeque<String> deque = new ArrayDeque<>();
            for (int j = 0; j < line.length; j++) {
                if (deque.isEmpty()) {
                    deque.addLast(line[j]);
                } else if (deque.peekLast().equals("(") && line[j].equals(")")) {
                    deque.pollLast();
                } else {
                    deque.addLast(line[j]);
                }
            }
            if (deque.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}