import java.util.*;

class Solution {
    public long solution(long n) {
        String[] numbers = String.valueOf(n).split("");
        
        Arrays.sort(numbers, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            sb.append(numbers[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}