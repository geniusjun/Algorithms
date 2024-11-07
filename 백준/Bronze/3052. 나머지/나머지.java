import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        Set<Integer> uniqueValues = new HashSet<>(); // Set 선언

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt() % 42;
            uniqueValues.add(arr[i]); // Set에 값 추가 (중복은 자동으로 제거)
        }

        // Set의 크기 출력 (고유한 값의 개수)
        System.out.println(uniqueValues.size());
    }
}