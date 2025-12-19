import java.util.ArrayDeque;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek().equals(String.valueOf(s.charAt(i)))){
                stack.pop();
            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}