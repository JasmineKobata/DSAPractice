class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer;

        Set<Integer> nums1set = new HashSet<Integer>();
        Set<Integer> nums2set = new HashSet<Integer>();

        for (int i=0; i < nums1.length; i++) {
            nums1set.add(nums1[i]);
        }
        for (int i=0; i < nums2.length; i++) {
            nums2set.add(nums2[i]);
        }

        
    }
}