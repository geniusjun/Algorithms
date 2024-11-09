import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();  // 앞뒤 공백 제거

        if (input.isEmpty()) {  // 공백만 있을 경우
            System.out.println(0);
        } else {
            String[] s = input.split(" ");
            System.out.println(s.length);
        }
    }
}