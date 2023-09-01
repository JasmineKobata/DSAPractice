class Solution {
    public int findPeakElement(int[] nums) {
        int start = 1, end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid-1] > nums[mid]) {
                return findPeakElement(Arrays.copyOfRange(nums, start, mid));
            }
            if (nums[mid+1] > nums[mid]) {
                return findPeakElement(Arrays.copyOfRange(nums, mid, end + 1));
            }
            if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
                return mid;
            }
        }

        return 0;
    }
}