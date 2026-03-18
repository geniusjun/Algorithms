import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char word = input.charAt(i);
            if (!deque.isEmpty()) {
                if (bomb.indexOf(word) == -1) { // 폭발 문자열 아닌경우
                    deque.addLast(word);
                } else { // 폭발 문자열인 경우
                    deque.addLast(word); // 넣고 tempQ에 옮겨서 확인해보기
                    boolean isBomb = false;
                    ArrayDeque<Character> tempQ = new ArrayDeque<>();
                    for (int j = bomb.length() - 1; j >= 0; j--) {
                        if (deque.isEmpty()) {
                            isBomb = false;
                            break;
                        }
                        if (deque.peekLast() == bomb.charAt(j)) {
                            tempQ.addLast(deque.pollLast());
                            isBomb = true;
                        } else {
                            isBomb = false;
                            break;
                        }
                    }
                    if (!isBomb) { // 만약 tempQ에 있는게 폭발 문자열이 아니라면 원복
                        while (!tempQ.isEmpty()) {
                            deque.addLast(tempQ.pollLast());
                        }
                    }
                }
            } else {
                // 비었는데 처음 들어오는 게 폭발 문자열인 경우
                deque.addLast(word); // 일단 넣고 tempQ에 옮겨서 확인해보기
                boolean isBomb = false;
                ArrayDeque<Character> tempQ = new ArrayDeque<>();
                for (int j = bomb.length() - 1; j >= 0; j--) {
                    if (deque.isEmpty()) {
                        isBomb = false;
                        break;
                    }
                    if (deque.peekLast() == bomb.charAt(j)) {
                        tempQ.addLast(deque.pollLast());
                        isBomb = true;
                    } else {
                        isBomb = false;
                        break;
                    }
                }
                if (!isBomb) { // 만약 tempQ에 있는게 폭발 문자열이 아니라면 원복
                    while (!tempQ.isEmpty()) {
                        deque.addLast(tempQ.pollLast());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            System.out.println("FRULA");
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
