import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
                int[] arr1 = {1,2,3,4,5};
        int one = 0;

        int[] arr2 = {2,1,2,3,2,4,2,5};
        int two = 0;

        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int three = 0;

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr1[i%5]){
                one++;
            }
        }
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr2[i%8]){
                two++;
            }
        }
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr3[i%10]){
                three++;
            }
        }
        int max = Math.max(one, two);
        int realMax = Math.max(max, three);
        List<Integer> result = new ArrayList<>();
        if(one == realMax) result.add(1);
        if(two == realMax) result.add(2);
        if (three == realMax) result.add(3);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}