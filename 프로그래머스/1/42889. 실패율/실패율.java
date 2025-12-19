import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> stageFail = new HashMap<>();
        for(int i = 1; i <=N; i++){
            int failCount = 0;
            int reachedCount = 0;
            for(int j = 0; j < stages.length; j++){
                if (stages[j] == i) {
                    failCount++;          // 실패자
                }
                if (stages[j] >= i) {
                    reachedCount++;       // 도달자
                }

            }
            double fail = (reachedCount == 0) ? 0.0 : (double) failCount / reachedCount;
            stageFail.put(i, fail);
        }
        List<Map.Entry<Integer, Double>> list =
                new ArrayList<>(stageFail.entrySet());
        list.sort((a, b) -> {
            int cmp = Double.compare(b.getValue(), a.getValue());
            if (cmp != 0) return cmp;
            return Integer.compare(a.getKey(), b.getKey());
        });


        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}