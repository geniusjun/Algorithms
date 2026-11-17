import java.util.*;
import java.io.*;

public class 일곱난쟁이2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - (arr[i] + arr[j]) == 100){
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(i == idx1 || i == idx2){
                continue;
            }
            list.add(arr[i]);
        }

        list.sort((o1,o2) -> {
            return o1 - o2;
        });
        for(int i = 0; i < 7; i++){
            System.out.println(list.get(i));
        }
    }
}