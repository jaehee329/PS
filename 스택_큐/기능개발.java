import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) { 
        if(speeds.length==0){
            return new int[]{};
        }
        int prev = (int)Math.ceil((double)(100-progresses[0])/speeds[0]);
        int idx = 0;
        int len = 0;
        for(int i=0; i<speeds.length; i++){
            int t = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(t>prev){
                speeds[len] = idx;
                prev = t;
                idx = 0;
                len++;
            }
            idx++;
        }
        speeds[len] = idx;
        len++;
        return Arrays.copyOfRange(speeds, 0, len);
    }
}