import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            st.nextToken(); // 과목명
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            totalCredit += credit;

            double score = 0;

            if (grade.equals("A+")) {
                score = 4.5;
            } else if (grade.equals("A0")) {
                score = 4.0;
            } else if (grade.equals("B+")) {
                score = 3.5;
            } else if (grade.equals("B0")) {
                score = 3.0;
            } else if (grade.equals("C+")) {
                score = 2.5;
            } else if (grade.equals("C0")) {
                score = 2.0;
            } else if (grade.equals("D+")) {
                score = 1.5;
            } else if (grade.equals("D0")) {
                score = 1.0;
            } else if (grade.equals("F")) {
                score = 0.0;
            }

            sum += credit * score;
        }

        System.out.printf("%.6f", sum / totalCredit);

    }


}