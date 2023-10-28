class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int effectiveBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - effectiveBuy - fee);
            effectiveBuy = Math.min(effectiveBuy, prices[i] - profit);
        }
        
        return profit;
    }
}