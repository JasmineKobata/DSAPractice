class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        for (; fast < nums.length; fast++) {
            if (fast >= nums.length-2 || nums[fast] != nums[fast+2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}