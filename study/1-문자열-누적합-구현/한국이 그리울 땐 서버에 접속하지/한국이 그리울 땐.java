import java.io.*;

public class 한국이 그리울 땐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        int idx = pattern.indexOf("*");

        String start = pattern.substring(0, idx);
        String last = pattern.substring(idx + 1);

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            boolean isOkay = true;

            if (s.length() < start.length() + last.length()) {
                isOkay = false;
            }

            if (isOkay) {
                for (int j = 0; j < start.length(); j++) {
                    if (s.charAt(j) != start.charAt(j)) {
                        isOkay = false;
                        break;
                    }
                }
            }

            if (isOkay) {
                int cnt = s.length() - 1;
                for (int j = last.length() - 1; j >= 0; j--) {
                    if (s.charAt(cnt--) != last.charAt(j)) {
                        isOkay = false;
                        break;
                    }
                }
            }

            if (isOkay) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}