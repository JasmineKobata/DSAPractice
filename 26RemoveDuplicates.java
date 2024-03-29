class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1, fast = 1;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}