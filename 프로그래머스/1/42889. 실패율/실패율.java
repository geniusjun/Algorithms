import java.util.*;

class Solution {
        public int[] solution(int N, int[] stages) {
        int[] answer = new int[N+2];
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < stages.length; i++){
            answer[stages[i]]++;
        }

        double arrivers = stages.length;
        for(int i = 1; i <= N; i++){
            if(answer[i] == 0){
                map.put(i, 0.0);
            }
            else {
                map.put(i, answer[i] / arrivers);
                arrivers -= answer[i];
            }
        }

        return map.entrySet().stream().sorted((o1,o2)
                -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }
}