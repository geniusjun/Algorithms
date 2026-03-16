import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static class Person {
        int height;
        int count;

        Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Person> stack = new Stack<>();
        long ret = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());

            int cnt = 1;

            while (!stack.isEmpty() && stack.peek().height <= h) {
                Person top = stack.pop();

                ret += top.count;

                if (top.height == h) {
                    cnt += top.count;
                }
            }

            if (!stack.isEmpty()) {
                ret++;
            }

            stack.push(new Person(h, cnt));

        }

        System.out.println(ret);
    }
}
