import java.util.*;

class Solution
{
    public static int solution(int n, int a, int b) {
        int cnt = 0;
        while (Math.abs(b - a) >= 1) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a / 2 + 1;
            }
            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = b / 2 + 1;
            }
            cnt++;
        }
        return cnt;
    }
}