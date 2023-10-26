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
            int num2 = v.get(i).get(0);
            sum += num1;
            pq.add(num1);

            if (pq.size() > k) {
                sum -= pq.remove();
            }
            if (pq.size() == k) {
                System.out.print(sum);
                System.out.print(" ");
                System.out.println(num2);
                result = Math.max(result, sum*num2);
            }
        }

        System.out.println(v);

        return result;
    }
}