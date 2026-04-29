import java.util.*;
import java.io.*;

public class 일곱난쟁이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nans = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            nans[i] = num;
            sum += num;
        }

        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - nans[i] - nans[j] == 100){
                    num1 = nans[i];
                    num2 = nans[j];
                    break;
                }
            }
        }

        Arrays.sort(nans);

        for(int i = 0; i < 9; i++){
            if(nans[i] == num1 || nans[i] == num2){
                continue;
            }

            System.out.println(nans[i]);
        }
    }
}
