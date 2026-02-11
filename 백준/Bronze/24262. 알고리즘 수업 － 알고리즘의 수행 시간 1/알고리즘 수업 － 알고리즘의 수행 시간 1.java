import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력은 문제 조건상 의미 없음 (항상 수행 횟수 1)
        br.readLine();
        
        // 코드1 수행 횟수
        System.out.println(1);
        
        // 최고차항 차수 (O(1) → 차수 0)
        System.out.println(0);
    }
}
