import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();

        boolean isPal = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) - '0' != word.charAt(word.length() - 1 - i) - '0') {
                isPal = false;
            }
        }

        if (isPal) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}