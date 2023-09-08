class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        int result = 0, max = nums[0];
        
        while (start < end) {            
            if (nums[start] > nums[end]) {
                if (nums[start] > max) {
                    max = nums[start];
                    result = start;
                }
                end--;
            } else {
                if (nums[end] > max) {
                    max = nums[end];
                    result = end;
                }
                start++;
            }
        }

        return result;
    }
}