import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') {
                st.push(1);
            } else {
                if(st.size()==0) {
                    answer = false;
                    break;
                }
                st.pop();
            }
        }
        if(st.size()!=0) {
            answer = false;
        }
        return answer;
    }
}
