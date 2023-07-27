import java.util.Map.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, Set<Integer>> indices = new HashMap<>();
        HashMap<Integer, Set<Integer>> results = new HashMap<>();

        for (int i=0; i < isConnected.length; i++) {
            int index = findIdx(indices, i);
            for (int j=0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    if (!indices.containsKey(index))
                        indices.put(index, new HashSet<>());
                    indices.get(index).add(j);                        
                }
                // System.out.println(indices);
            }
        }
        System.out.println(indices);

        for (Entry<Integer, Set<Integer>> e : indices.entrySet()) {
            boolean merged = false;
            for (Integer i : e.getValue()) {
                int idx = findIdx(indices, i);
                if (indices.containsKey(e.getKey()) && idx != e.getKey()) {
                    Set<Integer> hashval1 = indices.get(idx);
                    Set<Integer> hashval2 = indices.get(e.getKey());
                    // System.out.print("A ");
                    // System.out.println(e.getKey());
                    hashval1.addAll(hashval2);
                    results.put(idx, hashval1);
                    merged = true;
                    // System.out.println(results);
                }
            }
            if (!merged) results.put(e.getKey(), e.getValue());
            // System.out.print("B ");
            System.out.println(results);
        }

        return results.size();
    }

    public int findIdx(HashMap<Integer, Set<Integer>> indices, int row) {
        for (Entry<Integer, Set<Integer>> e : indices.entrySet()) {
            if (e.getValue().contains(row)) {
                return e.getKey();
            }
        }

        return row;
    }
}