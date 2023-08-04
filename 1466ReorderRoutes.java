class Solution {
    public int dfs(int[][] connections, int currIdx, int city, int swaps) {
        for (int i=0; i < connections.length; i++) {
            if (i != currIdx) {
                if (connections[i][0] == city) {
                    swaps = dfs(connections, i, connections[i][1], swaps + 1);
                } else if (connections[i][1] == city) {
                    swaps = dfs(connections, i, connections[i][0], swaps);
                }
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

        // System.out.println(Arrays.toString(array));

        return dfs(connections, -1, 0, 0);
    }
}