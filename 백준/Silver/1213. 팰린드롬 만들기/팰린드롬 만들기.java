import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < name.length(); i++) {
            arr[name.charAt(i) - 'A']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        char[] answer = new char[name.length()];
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                while (arr[i] > 1) {
                    answer[count] = (char) (i + 'A');
                    answer[name.length() - 1 - count] = (char) (i + 'A');
                    count++;
                    arr[i] -= 2;
                }
            }
            if (arr[i] == 1) {
                answer[name.length() / 2] = (char) (i + 'A');
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }

    }

}