import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            int number = Integer.parseInt(line);
            int count = 1;
            int answer = 1;
            while (true) {
                if (count % number == 0) {
                    System.out.println(answer);
                    break;
                } else {
                    count = (count * 10) + 1;
                    count = count % number;
                    answer++;
                }
            }
        }
    }
}