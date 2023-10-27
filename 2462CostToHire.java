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
        for (int i=0; i < costs.length/2; i++) {
            if (!v.isEmpty()) {
                pq.add(v.remove(0));
                pq.add(v.remove(v.size() - 1));
            }
System.out.println(pq);
            if (pq.size() == candidates*2 || pq.size() == costs.length) {
                sum += pq.remove().get(0);
            }
        }

        System.out.println(pq);
        return sum;
    }
}