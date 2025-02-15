class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            } else if (i > 0 && first == nums[i - 1]) {
                continue;
            }
            int targetSum = -1 * first;
            int secondIdx = i + 1;
            int thirdIdx = nums.length - 1;
            while (secondIdx < thirdIdx) {
                int second = nums[secondIdx];
                int third = nums[thirdIdx];
                int sum = second + third;
                if (sum == targetSum) {
                    answer.add(List.of(first, second, third));
                    while (secondIdx < thirdIdx && second == nums[secondIdx + 1]) {
                        secondIdx++;
                    }
                    while (secondIdx < thirdIdx && third == nums[thirdIdx - 1]) {
                        thirdIdx--;
                    }
                    secondIdx++;
                    thirdIdx--;
                } else if (sum > targetSum) {
                    thirdIdx--;
                } else {
                    secondIdx++;
                }
            }
        }
        return answer;
    }
}