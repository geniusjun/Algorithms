import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        // 정답 배열 초기화
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        // 숫자 입력 받기
        StringTokenizer line2 = new StringTokenizer(bf.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line2.nextToken());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 오큰수 찾기
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                    answer[stack.peek()] = numbers[i];
                    stack.pop();
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}

