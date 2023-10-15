class Solution {
    public int rob(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        for (int i=0; i < nums.length; i++) {
            if (i < 1)
                dp.add(nums[i]);
            else if (i == 1)
                dp.add(Math.max(nums[i], nums[i-1]));
            else
                dp.add(Math.max(dp.get(i-2) + nums[i], dp.get(i-1)));
        }

        return dp.get(dp.size() - 1);
    }
}