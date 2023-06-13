class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> row = new HashMap<String, Integer>();
        int numOfPairs = 0;

        for (int i=0; i < grid.length; i++) {
            String s = Arrays.toString(grid[i]);

            if (!row.containsKey(s)) row.put(s, 0);
            row.put(s, row.get(s) + 1);
        }

        for (int j=0; j < grid[0].length; j++) {
            String s = "[";
            for (int i=0; i < grid.length; i++) {
                s += Integer.toString(grid[i][j]);
                if (i < grid.length - 1) s += ", ";
            }
            s += "]";

            if (row.containsKey(s)) numOfPairs += row.get(s); 
        }

        return numOfPairs;
    }
}