import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        boolean isWord = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' && i < s.length() - 1) {
                if (s.charAt(i + 1) != 'i') {
                    isWord = false;
                }
                i++;
            } else if (s.charAt(i) == 'k' && i < s.length() - 1) {
                if (s.charAt(i + 1) != 'a') {
                    isWord = false;
                }
                i++;
            } else if (s.charAt(i) == 'c' && i < s.length() - 2) {
                if (!(s.charAt(i + 1) == 'h' && s.charAt(i + 2) == 'u')) {
                    isWord = false;
                    i += 2;
                }
                i += 2;
            } else {
                isWord = false;
            }
            if (!isWord) {
                break;
            }
        }

        if (isWord) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


}