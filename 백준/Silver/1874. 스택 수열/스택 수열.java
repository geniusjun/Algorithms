import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int nextPush = 1;

        for(int i = 0; i < N; i++){
            int find = Integer.parseInt(bf.readLine());

            while(nextPush <= find){
                stack.push(nextPush++);
                sb.append("+\n");
            }

            if(stack.isEmpty() || stack.peek() != find){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);

    }
}

