class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxlen = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int len = 1;
                while (set.contains(num+len)) len++;
                maxlen = Math.max(len, maxlen);
            }
        }

        return maxlen;
    }
}