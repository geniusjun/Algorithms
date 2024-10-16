import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 입력된 문자열

        int[] alphabetCount = new int[26]; // 알파벳 개수를 저장할 배열

        // 입력 문자열을 순회하며 알파벳 개수 세기
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            alphabetCount[ch - 'a']++; // 'a'를 기준으로 인덱스 계산
        }

        // 결과 출력
        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
    }
} // 이 풀이도 너무 좋다 창준아
