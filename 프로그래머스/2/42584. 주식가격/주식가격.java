import java.util.*;

class Solution {

    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < prices.length; i++){
            int cnt = 0;
            for(int j = i; j < prices.length; j++){
                if(prices[j] >= prices[i]){
                    cnt++;
                } else{
                    cnt++;
                    break;
                }
            }
            list.add(cnt-1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}