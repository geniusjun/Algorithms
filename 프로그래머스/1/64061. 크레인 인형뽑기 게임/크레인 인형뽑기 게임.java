import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
                int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (!bucket.isEmpty() && bucket.peek() == board[j][moves[i] - 1]) {
                        bucket.pop();
                        board[j][moves[i] - 1] = 0;
                        answer+=2;
                        break;
                    }
                    bucket.push(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}