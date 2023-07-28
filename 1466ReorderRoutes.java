class Solution {
    public int dfs(int[][] connections, int currIdx, int city, int swaps) {
        for (int i=0; i < connections.length; i++) {
            if (i != currIdx) {
            if (connections[i][0] == city) {
                swaps++;
                dfs(connections, i, connections[i][1], swaps);
            } else if (connections[i][1] == city) {
                dfs(connections, i, connections[i][0], swaps);
            }                
            }
        }
        return swaps;
    }

    public int minReorder(int n, int[][] connections) {
        Set<Integer> visited = new HashSet<Integer>();
        int swaps = 0;
        
        for (int i=0; i < connections.length; i++) {
            if (connections[i][0] == 0) {
                swaps = dfs(connections, i, connections[i][1], 1);
            } else if (connections[i][1] == 0) {
                swaps = dfs(connections, i, connections[i][0], 0);
            }
        }

        return swaps;
    }
}