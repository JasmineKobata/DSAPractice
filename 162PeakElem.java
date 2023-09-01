class Solution {
    public int findPeakElement(int[] nums) {
        int start = 1, end = nums.length-2;
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[i-1] < nums[i] && nums[i+1] < nums[i]) {
                return mid;
            }
        }

        return 0;
    }
}