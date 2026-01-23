import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Node(Integer.parseInt(bf.readLine()), i);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));

        int maxMove = 0;
        for (int i = 0; i < N; i++) {
            maxMove = Math.max(maxMove, arr[i].index - i);
        }

        System.out.println(maxMove + 1);
    }


}