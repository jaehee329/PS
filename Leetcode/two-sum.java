class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] answer = new int[2];
        for (int first = 0; first < length - 1; first++) {
            int elem1 = nums[first];
            for (int second = first + 1; second < length; second++) {
                int elem2 = nums[second];
                int sum = elem1 + elem2;
                if (sum == target) {
                    answer[0] = first;
                    answer[1] = second;
                }
            }
        }
        return answer;
    }
}