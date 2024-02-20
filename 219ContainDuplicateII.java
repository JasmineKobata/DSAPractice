class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int diff = nums[i];
            if (map.containsKey(diff) && Math.abs(i - map.get(diff)) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}