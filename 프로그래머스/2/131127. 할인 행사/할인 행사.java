import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int checkDay = discount.length - 10;

        for(int i = 0; i <= checkDay; i++){
            HashMap<String, Integer> map = new HashMap<>();
            boolean isMember = true;
            for(int j = i; j < 10 + i; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            for(int k = 0; k < want.length; k++){
                if(map.getOrDefault(want[k], 0) != number[k]){
                    isMember = false;
                }
            }

            if(isMember){
                answer++;
            }
        }



        return answer;
    }
}