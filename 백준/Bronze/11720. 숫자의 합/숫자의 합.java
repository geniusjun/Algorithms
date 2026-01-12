import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String nums = br.readLine();
        int sum = 0;
        for(int i = 0; i < nums.length(); i++){
            sum += nums.charAt(i) - '0';
        }

        System.out.println(sum);

    }
}
