import java.util.Map.*;

class Solution {
    public void dfs(int[][] array, Set<Integer> visited, int i) {
        for (int j=0; j < array[i].length; j++) {
            if (array[i][j] == 1 && !visited.contains(j)) {
                visited.add(j);
                dfs(array, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<Integer>();
        int results = 0;

        for (int i=0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                results++;
                visited.add(i);
                dfs(isConnected, visited, i);
            }
        }

        return results;
    }
}