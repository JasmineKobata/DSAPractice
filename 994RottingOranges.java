class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        boolean allRotten = false;

        while (!allRotten) {
            allRotten = true;
            for (int i=0; i < grid.length; i++) {
                for (int j=0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        allRotten = updateGrid(grid, i, j);
                    }
                }
            }
        }

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }

    public boolean updateGrid(int[][] grid, int x, int y) {
        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};

        boolean freshFound = false;

        if (inBounds(left, grid)) {
            grid[left[0]][left[1]] = 2;
            freshFound = true;
        }
        if (inBounds(right, grid)) {
            grid[right[0]][right[1]] = 2;
            freshFound = true;
        }
        if (inBounds(up, grid)) {
            grid[up[0]][up[1]] = 2;
            freshFound = true;
        }
        if (inBounds(down, grid)) {
            grid[down[0]][down[1]] = 2;
            freshFound = true;
        }

        return freshFound;
    }

    public boolean inBounds(int[] sqr, int[][] grid) {
        int x = sqr[0], y = sqr[1];

        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
            && grid[x][y] == 1;
    }
}