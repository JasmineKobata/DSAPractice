class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Vector<Vector<Integer>> v;        

        for (int i=0; i < k; i++) {
            v.add({nums2[i], nums1[i]});
        }

        return 0L;
    }
}