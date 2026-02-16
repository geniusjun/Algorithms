import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> oper;
    static List<Integer> nums;
    static int ret;
    static int operLength;

    static int cal(int a, int b, String oper) {
        if (oper.equals("+")) {
            return a + b;
        } else if (oper.equals("-")) {
            return a - b;
        }
        return a * b;

    }

    static void go(int idx, int value) {
        if (idx == operLength) {
            ret = Math.max(value, ret);
            return;
        }

        go(idx + 1, cal(value, nums.get(idx + 1), oper.get(idx)));

        if (idx + 1 < operLength) { // 다음 연산자가 존재해야 다음거를 미리 계산하지! -> 괄호를 만들 수 있나 확인
            int nextValue = cal(nums.get(idx + 1), nums.get(idx + 2), oper.get(idx + 1));
            go(idx + 2, cal(value, nextValue, oper.get(idx)));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        oper = new ArrayList<>();
        nums = new ArrayList<>();

        String[] inputs = bf.readLine().split("");
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.parseInt(inputs[i]));
            } else {
                oper.add(inputs[i]);
            }
        }
        ret = Integer.MIN_VALUE;
        operLength = (N + 1) / 2 - 1;
        go(0, nums.get(0));

        System.out.println(ret);
    }
}