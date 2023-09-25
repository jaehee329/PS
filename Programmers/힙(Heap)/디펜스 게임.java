import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int length = enemy.length;
        if (length <= k) {
            return length;
        }
        
        for (int i = 0; i < k; i++) {
            pq.add(enemy[i]);
        }
        
        int remainder = n;
        int idx = k;
        while (remainder > 0 && idx < length) {
            int smallest = pq.peek();
            int next = enemy[idx];
            if (next < smallest && next <= remainder) {
                remainder -= next;
            } else if (smallest <= remainder) {
                remainder -= smallest;
                pq.poll();
                pq.add(enemy[idx]);
            } else {
                break;
            }
            idx++;
        }
        return idx;
    }
}
