class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int k = 1;

        for (; end < nums.length; end++) {
            if (nums[end] == 0) k--;
            if (k < 0) {
                if (nums[start] == 0) k++;
                start++;
            }
        }

        return end - start - 1;
    }
}