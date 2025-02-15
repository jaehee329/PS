class Solution {
    public int arrayPairSum(int[] nums) {
        // pair 중 최소들의 합이 최대가 되게 해라. => greedy로 작은 순으로 pair
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}