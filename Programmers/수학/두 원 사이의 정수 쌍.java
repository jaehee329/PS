class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        for (int x = 1; x <= r2; x++) {
            int bottom = (int) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x));
            int top = (int) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x));
            count += top - bottom + 1;
        }
        return count * 4;
    }
}
