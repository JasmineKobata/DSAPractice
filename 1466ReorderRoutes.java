class Solution {
    public int dfs(ArrayList<int[]>[] connections, int i, Set<Integer> vis, int swaps) {
        vis.add(i);

        for (int[] elem: connections[i]) {
            if (!vis.contains(elem[0])) {
                swaps = dfs(connections, elem[0], vis, swaps + elem[1]);
            }
        }

        return swaps;
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]>[] array = new ArrayList[n];
        Set<Integer> visited = new HashSet<Integer>();

        for (int i=0; i<n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int[] elem : connections) {
            array[elem[0]].add(new int[]{elem[1], 1});
            array[elem[1]].add(new int[]{elem[0], 0});
        }

        return dfs(array, 0, visited, 0);
    }
}