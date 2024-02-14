class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        String s = Integer.toString(nums[0]);

        for (int i=1; i < nums.length; i++) {
            if (nums[i-1] + 1 == nums[i]
                && (i+1 == nums.length || nums[i+1] != nums[i] + 1)) {
                s = s + "->" + Integer.toString(nums[i]);
            } else if (nums[i-1] + 1 != nums[i]) {
                list.add(s);
                s = Integer.toString(nums[i]);
            }
        }
        list.add(s);
        return list;
    }
}