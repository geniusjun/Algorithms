import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            String number = "";
            boolean isStart = false; // 숫자가 시작중인지 아닌지를 판단하는 플래그 변수

            for (int j = 0; j < line.length(); j++) {
                Character ch = line.charAt(j);

                if (Character.isDigit(ch)) { // 숫자일경우
                    isStart = true;
                    if (number.isEmpty() && ch == '0') { // 앞에는 0이 오지 못한다.
                        continue;
                    }
                    number += ch;
                } else { // 숫자 아닐 경우
                    if (isStart) {
                        if (number.isEmpty()) { // 숫자 시작했는데? 비어있다는 것은 0이 들어왔다는 것.
                            list.add("0");
                        } else {
                            list.add(number);
                        }
                        number = "";
                        isStart = false;
                    }
                }
            }
            if (isStart) { // 줄 끝에서 숫자로 끝난 경우
                if (number.isEmpty()) { // 숫자 시작했는데? 비어있다는 것은 0이 들어왔다는 것.
                    list.add("0");
                } else {
                    list.add(number);
                }
            }
        }

        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}