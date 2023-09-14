class Solution {
    public int minCostClimbingStairs(int[] cost) {
        List<Integer> dp = new ArrayList<>(Arrays.asList(cost[0], cost[1]));

        for (int i=2; i<cost.length; i++) {
            dp.add(cost[i] + Math.min(dp.get(i-1), dp.get(i-2)));
        }
        return dp.get(cost.length-1);
    }
}