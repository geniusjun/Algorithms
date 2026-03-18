import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static String s, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        b = br.readLine(); // 12ab
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);
            if (stack.size() > b.length() - 1 && c == b.charAt(b.length() - 1)) {
                ArrayDeque<Character> tempQ = new ArrayDeque<>();
                boolean isBomb = true;
                for (int j = b.length() - 1; j >= 0; j--) {
                    char temp = stack.pollLast();
                    if (temp == b.charAt(j)) {
                        tempQ.addLast(temp);
                    } else {
                        tempQ.addLast(temp);
                        isBomb = false;
                        break;
                    }
                }
                if (!isBomb) {
                    while (!tempQ.isEmpty()) {
                        stack.addLast(tempQ.pollLast());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
