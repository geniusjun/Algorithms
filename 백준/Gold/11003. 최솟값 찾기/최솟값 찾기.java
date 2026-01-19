import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(line1.nextToken());
        int L = Integer.parseInt(line1.nextToken());

        StringTokenizer line2 = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(line2.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.pollLast();
            }

            deque.addLast(new Node(now, i));

            if (deque.getFirst().index <= i - L) {
                deque.pollFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
    }
}

