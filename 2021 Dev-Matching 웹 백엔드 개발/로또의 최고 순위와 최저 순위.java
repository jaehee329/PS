import java.util.ArrayList;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<6; i++) {
            arr.add(win_nums[i]);
        }
        int zeros = 0;
        int correct = 0;
        for(int i=0; i<6; i++) {
            int target = lottos[i];
            if(target == 0) {
                zeros++;
            } else if(arr.contains(target)){
                correct++;
            }
        }
        int[] rank = {6,6,5,4,3,2,1};
        int[] answer = {rank[correct+zeros], rank[correct]};
        return answer;
    }
}