class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i=0; i < nums.length; i++) {
            if (i == 0) left[i] = nums[i];
            else left[i] = Math.min(left[i-1], nums[i]);
        }
        for (int i=nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) right[i] = nums[i];
            else right[i] = Math.max(right[i+1], nums[i]);
        }
        for (int i=1; i < nums.length; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) return true;
        }

        return false;
    }
}