import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        int before = -1;
        for(int i=0; i<arr.length; i++) {
            int t = arr[i];
            if(t != before) {
                q.add(t);
                before = t;
            }
        }
        int[] answer = new int[q.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}