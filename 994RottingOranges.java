class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = -1;
        Boolean allRotten = false;

        while (!allRotten) {
            allRotten = true;
            minutes++;
            int[][] tempGrid = copyArray(grid);
            for (int i=0; i < grid.length; i++) {
                for (int j=0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        allRotten &= updateGrid(grid, tempGrid, i, j);
                    }
                }
            }
    for (int x=0; x < grid.length; x++) {
        System.out.print(Arrays.stream(grid[x]).boxed().toList().toString());
        System.out.println(Arrays.stream(tempGrid[x]).boxed().toList().toString());}

        grid = copyArray(tempGrid);
        }

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }

    public boolean updateGrid(int[][] grid, int[][] tempGrid, int x, int y) {
        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};

        boolean allRotten = true;

        if (inBounds(left, grid)) {
            tempGrid[left[0]][left[1]] = 2;
            allRotten &= false;
        }
        if (inBounds(right, grid)) {
            tempGrid[right[0]][right[1]] = 2;
            allRotten &= false;
        }
        if (inBounds(up, grid)) {
            tempGrid[up[0]][up[1]] = 2;
            allRotten &= false;
        }
        if (inBounds(down, grid)) {
            tempGrid[down[0]][down[1]] = 2;
            allRotten &= false;
        }

        return allRotten;
    }

    public boolean inBounds(int[] sqr, int[][] grid) {
        int x = sqr[0], y = sqr[1];

        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
            && grid[x][y] == 1;
    }

    public int[][] copyArray(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];

        for (int i=0; i < copy.length; i++) {
            for (int j=0; j < copy[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
}