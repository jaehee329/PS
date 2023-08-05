class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int length = sequence.length;
        int minIdx = 0;
        int maxIdx = 0;
        int answerMinLength = length;
        int[] answer = new int[2];
        while (minIdx < length && maxIdx < length) {
            if (sum <= k) {
                if (sum == k && (maxIdx - minIdx) < answerMinLength) {
                    answerMinLength = maxIdx - minIdx;
                    answer[0] = minIdx;
                    answer[1] = maxIdx;
                }
                maxIdx++;
                if (maxIdx >= length) {
                    break;
                }
                sum += sequence[maxIdx];
            } else if (sum > k) {
                sum -= sequence[minIdx];
                minIdx++;
            }
        }
        return answer;
    }
}