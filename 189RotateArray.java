class Solution {
    public void rotate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            map.put((i + k) % nums.length, nums[i]);
        }

        for (int i=0; i < nums.length; i++) {
            nums[i] = map.get(i);
        }
    }
}