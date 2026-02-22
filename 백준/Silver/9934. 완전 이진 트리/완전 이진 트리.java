import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static List<Integer>[] answer;
    static List<Integer> tree;

    static void go(int level, int start, int end) {
        if (level == K || start > end) {
            return;
        }

        int mid = (start + end) / 2;
        answer[level].add(tree.get(mid));

        go(level + 1, start, mid - 1);
        go(level + 1, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        answer = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            answer[i] = new ArrayList<>();
        }

        int size = 2;
        for (int i = 0; i < K - 1; i++) {
            size *= 2;
        }
        size -= 1;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        go(0, 0, size - 1);

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < answer[i].size(); j++) {
                System.out.print(answer[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}