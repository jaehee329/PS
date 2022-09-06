import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            h.add(nums[i]);
        }
        return nums.length/2 > h.size() ? h.size() : nums.length/2;
    }
}