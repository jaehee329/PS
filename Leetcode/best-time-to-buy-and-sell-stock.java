class Solution {
    public int maxProfit(int[] prices) {
        // price[i] 이전의 최저가만 알면 된다.
        int min = prices[0];
        int maxGap = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
                continue;
            }
            maxGap = Math.max(maxGap, price - min);
        }
        return maxGap;
    }
}