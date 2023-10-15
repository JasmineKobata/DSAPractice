class Solution {
    public int rob(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        for (int i=0; i < nums.length; i++) {
            if (i < 2)
                dp.add(nums[i]);
            else {
                dp.add(Math.max(dp.get(i-2) + nums[i], dp.get(i-1)));
            }
        }

        return dp.get(dp.size() - 1);
    }
}