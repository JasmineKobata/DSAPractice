class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = 1;
        int sum = 0;

        while (end < prices.length) {
            int max = 0;
            while (end < prices.length && prices[end] > prices[end-1]) {
                max = Math.max(max, prices[end] - prices[start]);
                end++;
            }
            sum += max;
            start = end;
            end++;
        }
        return sum;
    }
}