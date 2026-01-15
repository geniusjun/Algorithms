import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> earnMap = new HashMap<>();
        HashMap<String, String> childAndParent = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            earnMap.put(enroll[i], 0);
        }
        for (int i = 0; i < enroll.length; i++) {
            childAndParent.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < seller.length; i++) {
            int earn = amount[i] * 100;
            String key = seller[i];
            if (earn / 10 == 0){
                continue;
            }
            earnMap.put(key, earnMap.get(key) + (earn - (earn / 10)));
            while (!childAndParent.get(key).equals("-") && earn / 10 != 0) {
                key = childAndParent.get(key);
                earn = earn / 10;
                earnMap.put(key, earnMap.get(key) + (earn - (earn / 10)));
            }
        }
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = earnMap.get(enroll[i]);
        }
        return answer;
    }
}