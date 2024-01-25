class Solution {
    public boolean canJump(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length - 1) {
            fast = Math.max(fast, slow + nums[slow]);
            if (slow == fast) return false;
            slow++;
        }
        return true;
    }
}