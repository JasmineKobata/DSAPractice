import java.util.Map.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, Set<Integer>> indices = new HashMap<>();

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
            for (Integer i : e.getValue()) {
                int idx = findIdx(indices, i);
                if (indices.containsKey(e.getKey()) && idx != e.getKey()) {
                    Set<Integer> hashval1 = indices.remove(idx);
                    Set<Integer> hashval2 = indices.remove(e.getKey());
                    System.out.println(e.getKey());
                    hashval1.addAll(hashval2);
                    indices.put(idx, hashval1);
                }
                System.out.println(indices);
            }
        }

        return indices.size();
    }

    public int findIdx(HashMap<Integer, Set<Integer>> indices, int row) {
        for (Entry<Integer, Set<Integer>> e : indices.entrySet()) {
            if (e.getValue().contains(row)) {
                // System.out.println(e);
                return e.getKey();
            }
        }

        return row;
    }
}