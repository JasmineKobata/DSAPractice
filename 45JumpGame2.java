class Solution {
    public int jump(int[] nums) {
        int start = 0, end = 0;
        int count = 0;

        while (end < nums.length-1) {
            int max = 0;
            while (start <= end) {
                max = Math.max(max, start + nums[start]);
                start++;
            }
            end = max;
            count++;
        }
        return count;
    }
}