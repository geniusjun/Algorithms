import java.util.Stack;

class Solution {
    boolean solution(String s) {
          boolean answer = true;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && !stack.empty() && stack.peek().equals("(")){
                stack.pop();
            } else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        if(!stack.empty()){
            answer = false;
        }

        return answer;
    }
}