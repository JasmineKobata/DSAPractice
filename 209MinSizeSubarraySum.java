class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}