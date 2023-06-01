class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList();
        Set<Integer> answerNums1 = new HashSet<>();
        Set<Integer> answerNums2 = new HashSet<>();

        Set<Integer> nums1set = new HashSet<Integer>();
        Set<Integer> nums2set = new HashSet<Integer>();

        for (int i=0; i < nums1.length; i++) {
            nums1set.add(nums1[i]);
        }
        for (int i=0; i < nums2.length; i++) {
            nums2set.add(nums2[i]);
        }

        for (int i=0; i < nums1.length; i++) {
            if (!nums2set.contains(nums1[i])) {
                answerNums2.add(nums1[i]);
            }
        }
        for (int i=0; i < nums2.length; i++) {
            if (!nums1set.contains(nums2[i])) {
                answerNums1.add(nums2[i]);
            }
        }

        answer.add(new ArrayList<>(answerNums2));
        answer.add(new ArrayList<>(answerNums1));

        return answer;
    }
}