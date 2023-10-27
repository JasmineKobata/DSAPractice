import java.util.*;

class SortPairs implements Comparator<Vector<Integer>> {
    @Override public int compare(Vector<Integer> a, Vector<Integer> b) {
        if (a.get(0) == b.get(0)) return a.get(1).compareTo(b.get(1));
        return a.get(0).compareTo(b.get(0));
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Vector<Integer>> pq = new PriorityQueue<>(new SortPairs());
        Vector<Vector<Integer>> v = new Vector<>();

        for (int i=0; i < costs.length; i++) {
            v.add(new Vector<>(Arrays.asList(costs[i], i)));
        }

        long sum = 0;
        int leftRight = 0; //left = -1, right = 1
        while (k > 0) {
            if (!v.isEmpty() && leftRight < 1) {
                Vector<Integer> v1 = v.remove(0);
                v1.add(-1);
                pq.add(v1);
            } if (!v.isEmpty() && leftRight > -1) {
                Vector<Integer> v2 = v.remove(v.size() - 1);
                v2.add(1);
                pq.add(v2);
            }
            
System.out.println(pq);
            if (pq.size() == candidates*2 || v.isEmpty()) {
                Vector<Integer> elem = pq.remove();
                sum += elem.get(0);
                leftRight = elem.get(2);
                k--;
                System.out.println(sum);
            }
        }

        System.out.println(pq);
        return sum;
    }
}