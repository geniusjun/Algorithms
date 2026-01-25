import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        char[] charArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArr[i] = str.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] >= 65 && charArr[i] < 97) { // 대문자
                if (charArr[i] + 13 >= 91) {
                    sb.append((char) ((charArr[i] + 13) - 26));
                } else {
                    sb.append((char) (charArr[i] + 13));
                }
            } else if (charArr[i] >= 97 && charArr[i] <= 123) { // 소문자
                if (charArr[i] + 13 >= 123) {
                    sb.append((char) ((charArr[i] + 13) - 26));
                } else {
                    sb.append((char) (charArr[i] + 13));
                }
            } else {
                sb.append(charArr[i]);
            }
        }

        System.out.println(sb);

    }
}