import java.util.Map.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, Set<Integer>> indices = new HashMap<>();

        for (int i=0; i < isConnected.length; i++) {
            int index = findIdx(indices, i);
            System.out.println(index);
            for (int j=0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    if (!indices.containsKey(index))
                        indices.put(index, new HashSet<>());
                    indices.get(index).add(j);                        
                }
            }
        }

        return indices.size();
    }

    public int findIdx(HashMap<Integer, Set<Integer>> indices, int row) {
        int result = row;

        for (Entry<Integer, Set<Integer>> e : indices.entrySet()) {
            if (e.getValue().contains(row)) result = e.getKey();
        }

        return result;
    }
}