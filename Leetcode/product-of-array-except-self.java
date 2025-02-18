class Solution {
    public int[] productExceptSelf(int[] nums) {
        // max(answer[i]) = 42억, nums_pi(0, length) <= 42억 * 42억 => 전체 곱을 long으로 처리 시 ok
        // nums = [Integer.MAX, Integer.MAX]인 경우 포함해서 테스트해봐야 함.
        // 전체 곱 후 특정 값 나누기가 불가능한 경우 -> element = 0인 경우 => nums[i]를 빼고 다시 곱해야 하므로 전체 곱을 사용하는 방식은 불가
        // 전체에서 2개 이상의 0이 있는 경우 -> 전체 곱은 무조건 0이며, nums[i]를 제외한 nums_pi는 언제나 0
        // 전체에서 i번째에 0 하나가 있는 경우 -> nums_pi[i]는 0을 제외한 전체 곱. 나머지는 항상 0
        // 전체에서 0이 없는 경우 -> 전체 곱에서 long으로 나누면 됨
        long totalMult = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            } else {
                if (zeroCount <= 1) {
                    totalMult *= num;
                } else {
                    totalMult = 0;
                    break;
                }
            }
        }
        int[] answer = new int[nums.length];
        if (zeroCount >= 2) {
            return answer;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    answer[i] = (int) totalMult;
                } else {
                    answer[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = ((int) totalMult) / nums[i];
            }
        }
        return answer;
    }
}
