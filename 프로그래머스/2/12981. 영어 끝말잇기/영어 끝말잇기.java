import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        int cnt = 0;
        boolean isgame = true;
        for (int i = 1; i <= words.length - 1; i++) {
            if (set.contains(words[i]) || !words[i].startsWith(words[i - 1].substring(words[i - 1].length() - 1))) {
                cnt = i;
                isgame = false;
                break;
            }
            set.add(words[i]);
        }
        int[] answer = new int[2];
        if (!isgame) {
            int who = (cnt + 1) % n;
            int when = (cnt + n) / n;
            if (who == 0) {
                who = n;
            }
            answer = new int[]{who, when};
        } else {
            answer = new int[]{0, 0};
        }
        return answer;
    }
}