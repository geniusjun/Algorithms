import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String patternLine = bf.readLine();
        String[] patterns = patternLine.split("\\*");

        for (int i = 0; i < N; i++) {
            boolean isPattern = true;
            String check = bf.readLine();
            if (!check.startsWith(patterns[0])
                    || !check.endsWith(patterns[1]) || check.length()
                    < patterns[0].length() + patterns[1].length()) {
                isPattern = false;
            }

            if (isPattern) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }

        }

    }
}