import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int h = board.length;
        int w = board[0].length;
        Stack<Integer> s = new Stack<>();
        int len = moves.length;
        for(int i=0; i<len; i++) {
            int depth = 0;
            while(depth<h){
                int t = board[depth][moves[i]-1];
                if(t != 0){
                    if(s.size()>0 && s.peek()==t){
                        s.pop();
                        answer+=2;
                    } else {
                        s.push(t);
                    }
                    board[depth][moves[i]-1]=0;
                    break;
                }
                depth++;
            }
        }
        return answer;
    }
}