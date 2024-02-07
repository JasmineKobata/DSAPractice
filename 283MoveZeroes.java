class Solution {
    public void moveZeroes(int[] nums) {
        int currentIdx = 0;
        int checkIdx = 1;

        while (currentIdx < nums.length) {
            while (checkIdx < nums.length && nums[checkIdx] == 0) {
                checkIdx++;
            }

            if (nums[currentIdx] == 0 && checkIdx < nums.length) {
                int temp = nums[currentIdx];
                nums[currentIdx] = nums[checkIdx];
                nums[checkIdx] = temp;
                currentIdx++;
                checkIdx++;
            } else {
                currentIdx++;
            }
            if (currentIdx == checkIdx)
                checkIdx++;
        }
    }
}