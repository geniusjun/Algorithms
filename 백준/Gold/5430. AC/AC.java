import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static int T, n;
    static String p, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            boolean isError = false;
            boolean isReverse = false;
            p = bf.readLine();
            n = Integer.parseInt(bf.readLine());
            arr = bf.readLine();
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for (String num : nums) {
                    deque.addLast(Integer.parseInt(num));
                }
            }
            for (int i = 0; i < p.length(); i++) {
                char oper = p.charAt(i);
                if (oper == 'R') {
                    isReverse = !isReverse;
                } else { // D
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error");
            } else {
                int size = deque.size();
                sb.append("[");

                if (isReverse) {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.pollLast());
                        if (i != size - 1) {
                            sb.append(",");
                        }
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        sb.append(deque.pollFirst());
                        if (i != size - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}