import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i; j < numbers.length - 1; j++){
                answer.add(numbers[i] + numbers[j+1]);
            }
        }
        int[] result = answer.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        return result;
    }
}