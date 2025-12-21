import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            deque.addLast(progresses[i]);
        }
        int done = 0;
        while(deque.size() > 0){
            int cnt = 0;
            for(int i = 0; i < deque.size(); i++){
                int temp = deque.pollFirst() + speeds[done + i];
                deque.addLast(temp);
            }
            while(!deque.isEmpty() && deque.peekFirst() >= 100){
                deque.pollFirst();
                cnt++;
                done++;
            }
            if(cnt!= 0){
                list.add(cnt);
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}