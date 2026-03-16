import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int ret = Integer.MIN_VALUE;
        int[] arr = new int[n + 4];
        Stack<Integer> stack = new Stack<>();
        String input = bf.readLine();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) { // '(' 가 들어왔고, ')'가 들어오는 경우
                arr[stack.pop()] = 1;
                arr[i] = 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
            } else {
                ret = Math.max(ret, cnt);
                cnt = 0;
            }
        }
        ret = Math.max(ret, cnt);

        System.out.println(ret);
    }

}