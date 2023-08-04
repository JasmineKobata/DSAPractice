class Solution {
    public int dfs(ArrayList<int[]>[] connections, int i, Set<Integer> vis) {
        vis.add(i);
        int swaps = 0;

        for (int[] elem: connections[i]) {
            if (!vis.contains(elem[0])) {
                swaps += dfs(connections, elem[0], vis) + elem[1];
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

        System.out.println(Arrays.toString(array));

        for (int[] elem : connections) {
            array[elem[0]].add(new int[]{elem[1], 1});
            array[elem[1]].add(new int[]{elem[0], 0});
        }

        for (int i=0; i<n; i++) {
            for (int[] arr : array[i]) {
                System.out.print(Arrays.toString(arr));
                System.out.print(" ");                         
            }
            System.out.println();
        }

        return dfs(array, 0, visited);
    }
}