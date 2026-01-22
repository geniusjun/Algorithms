import java.util.*;

class Solution {
    public long solution(long n) {
                int[] arr = new int[11];
        String s = String.valueOf(n);
        long cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - '0']++;
            cnt *= 10;
        }
        cnt /= 10;
        long answer = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                answer += (long) i * cnt;
                cnt /= 10;
            }
        }

        return answer;
    }
}