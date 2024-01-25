class Solution {
    public int maxProfit(int[] prices) {
        int slow = 0, fast = 0;
        int max = 0;

        while (fast < prices.length) {
            max = Math.max(max, prices[fast] - prices[slow]);
            if (prices[fast] < prices[slow]) {
                slow = fast;
            }
            fast++;
        }
        return max;
    }
}