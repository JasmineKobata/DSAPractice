import java.util.*;

class SortPairs implements Comparator<Vector<Integer>> {
    @Override public int compare(Vector<Integer> a, Vector<Integer> b) {
        // if (a.get(0) == b.get(0)) return a.get(1).compareTo(b.get(1));
        return a.get(0).compareTo(b.get(0));
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
        long result = 0;
        long sum = 0;
        for (int i=nums1.length-1; i >= 0; i--) {
            int num1 = v.get(i).get(1);
            if (i > nums1.length - k) {
                sum += num1;
                pq.add(num1);
            } else {
                sum += num1;
                pq.add(num1);
                sum -= pq.remove();
            }
            System.out.println(pq);
            result = Math.max(result, sum*v.get(i).get(0));
        }

        System.out.println(v);

        return result;
    }
}