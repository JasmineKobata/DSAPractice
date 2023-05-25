class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int numOfPairs = 0;

        int head = 0, tail = nums.length-1;
        while(head < tail) {
            if (nums[head] + nums[tail] == k) {
                numOfPairs++;
                head++;
                tail--;
            } else if (nums[head] + nums[tail] > k) {
                tail--;
            } else {
                head++;
            }
        }
        return numOfPairs;
    }
}