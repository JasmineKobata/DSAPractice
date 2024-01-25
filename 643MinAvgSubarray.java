class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0, currentWindow = 0;
        for (int i=0; i < k; i++) {
            currentWindow += nums[i];
        }
        maxAvg = currentWindow / k;

        for (int i=0; i+k < nums.length; i++) {
            currentWindow -= nums[i];
            currentWindow += nums[i+k];
            double currentAvg = currentWindow / k;
            maxAvg = Math.max(maxAvg, currentAvg);
        }
        return maxAvg;
    }
}