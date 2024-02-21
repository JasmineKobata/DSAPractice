class Solution {
    public int numIslands(char[][] grid) {
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i=0; i < grid.length; i++) {
            for (int u=0; u < grid[i].length; u++) {
                int[] pos = new int[]{i, u};
                if (!set.contains(Arrays.toString(pos)) && grid[i][u] == '1') {
                    q.add(pos);
                    set.add(Arrays.toString(pos));
                    count++;
                }
                
                while (!q.isEmpty()) {
                    int[] idx = q.remove();
                    int x = idx[0], y = idx[1];
                    int[] left = new int[]{x-1, y}, right = new int[]{x+1, y};
                    int[] up = new int[]{x, y-1}, down = new int[]{x, y+1};
                    int[][] dirs = new int[][]{left, right, up, down};
                    
                    for (int d=0; d < dirs.length; d++) {
                        int dx = dirs[d][0], dy = dirs[d][1];
                        if (!set.contains(Arrays.toString(dirs[d]))
                            && dx >= 0 && dx < grid.length
                            && dy >= 0 && dy < grid[0].length
                            && grid[dx][dy] == '1') {
                            q.add(dirs[d]);
                            set.add(Arrays.toString(dirs[d]));
                        }
                    }
                }
            }
        }

        return count;
    }
}