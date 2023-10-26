import java.util.*;

class SortPairs implements Comparator<Vector<Integer>> {
    @Override public int compare(Vector<Integer> a, Vector<Integer> b) {
        return b.get(0).compareTo(a.get(0));
    }
}

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Vector<Vector<Integer>> v = new Vector<>();        

        for (int i=0; i < nums1.length; i++) {
            v.add(new Vector<>(Arrays.asList(nums2[i], nums1[i])));
        }
        v.sort(new SortPairs());

        System.out.println(v);

        return 0L;
    }
}