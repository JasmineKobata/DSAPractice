class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int minutes = 0, fresh = 0;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        
        int[][] dirs = new int[][]{new int[]{0, 1},new int[]{0, -1},new int[]{1, 0},new int[]{-1, 0}};
        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int i=0; i < len; i++) {
                int[] coords = q.remove();
                for (int[] dir : dirs) {
                    int x = coords[0] + dir[0], y = coords[1] + dir[1];
                    if (inBounds(new int[]{x, y}, grid)) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            minutes++;
        }

        return fresh < 1 ? minutes : -1;
    }

    public boolean inBounds(int[] sqr, int[][] grid) {
        int x = sqr[0], y = sqr[1];

        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
            && grid[x][y] == 1;
    }
}