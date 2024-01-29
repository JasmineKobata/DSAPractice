class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i=nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) postfix[i] = nums[i];
            else postfix[i] = postfix[i+1] * nums[i];
        }

        int prefix = 1;
        for (int i=0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfix[i+1];
            } else if (i == nums.length - 1) {
                prefix *= nums[i-1];
                result[i] = prefix;
            } else {
                prefix *= nums[i-1];
                result[i] = prefix * postfix[i+1];
            }
        }

        return result;
    }
}