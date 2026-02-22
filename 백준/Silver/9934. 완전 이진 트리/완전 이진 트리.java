import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static List<Integer>[] answer;

    static void go(int idx, List<Integer> beforeList, List<Integer> afterList) {
        if (beforeList.size() == 1 && afterList.size() == 1) {
            answer[idx].add(beforeList.get(0));
            answer[idx].add(afterList.get(0));
            return;
        }

        answer[idx].add(beforeList.get(beforeList.size() / 2));
        answer[idx].add(afterList.get(afterList.size() / 2));

        List<Integer> aBeforeList = new ArrayList<>();
        List<Integer> aAfterList = new ArrayList<>();
        List<Integer> bBeforeList = new ArrayList<>();
        List<Integer> bAfterList = new ArrayList<>();

        for (int i = 0; i < beforeList.size() / 2; i++) {
            aBeforeList.add(beforeList.get(i));
        }
        for (int i = beforeList.size() / 2 + 1; i < beforeList.size(); i++) {
            aAfterList.add(beforeList.get(i));
        }
        for (int i = 0; i < afterList.size() / 2; i++) {
            bBeforeList.add(afterList.get(i));
        }
        for (int i = afterList.size() / 2 + 1; i < afterList.size(); i++) {
            bAfterList.add(afterList.get(i));
        }

        go(idx + 1, aBeforeList, aAfterList);
        go(idx + 1, bBeforeList, bAfterList);

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        answer[0].add(list.get(size / 2));
        List<Integer> beforeList = new ArrayList<>();
        List<Integer> afterList = new ArrayList<>();
        for (int i = 0; i < size / 2; i++) {
            beforeList.add(list.get(i));
        }
        for (int i = size / 2 + 1; i < size; i++) {
            afterList.add(list.get(i));
        }

        go(1, beforeList, afterList);

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < answer[i].size(); j++) {
                System.out.print(answer[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}