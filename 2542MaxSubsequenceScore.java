class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] nums21 = new long[n];
        for (int i=0; i < n; i++) {
            nums21[i] = ((long)nums2[i] << 20) | nums1[i];
        }
        System.out.println(Arrays.toString(nums21));
        Arrays.sort(nums21);
        System.out.println(Arrays.toString(nums21));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        return 0;
    }
}