// 처음에 K이상의 수를 우선순위큐에 아예 넣지 않는 방법으로 했으나, K미만이 하나 남는 경우 K이상과 섞여 K를 넘을 수 있어 실패함.
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int len = scoville.length;
        for(int scov : scoville){
            q.add(scov);
        }
        int iter = 0;
        while(q.peek()<=K){
            if(q.size()==1){
                return -1;
            }
            iter++;
            int fst = q.poll();
            int sec = q.poll();
            fst = fst + 2*sec;
            q.add(fst);
        }
        return iter;
    }
}
