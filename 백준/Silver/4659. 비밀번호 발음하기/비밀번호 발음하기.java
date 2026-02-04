import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        while (!line.equals("end")) {
            boolean isAccept = true;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < line.length(); i++) {
                set.add(line.charAt(i));
            }
            if (!(set.contains('a') || set.contains('e') || set.contains('i') || set.contains('o') || set.contains(
                    'u'))) {
                isAccept = false;
            }

            int mo = 0;
            int ja = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o'
                        || line.charAt(i) == 'u') {
                    ja = 0;
                    mo++;
                } else {
                    mo = 0;
                    ja++;
                }

                if (mo == 3 || ja == 3) {
                    isAccept = false;
                    break;
                }
            }

            for (int i = 0; i < line.length() - 1; i++) {
                int temp = i + 1;
                if (line.charAt(i) == line.charAt(temp)) {
                    if (!(line.charAt(i) == 'e' || line.charAt(i) == 'o')) {
                        isAccept = false;
                        break;
                    }
                }
            }

            if (isAccept) {
                System.out.println("<" + line + ">" + " is acceptable.");
            } else {
                System.out.println("<" + line + ">" + " is not acceptable.");
            }

            line = bf.readLine();
        }
    }
}