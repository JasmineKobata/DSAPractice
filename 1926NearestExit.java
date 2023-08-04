class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Set<List<Integer>> visited = new HashSet();
        visited.add(Arrays.asList(entrance));
        System.out.println(visited);
        return bfs(maze, visited, entrance);
    }

    public int bfs(char[][] maze, Set<List<Integer>> visited, int[] currentSqr) {
        if (isBorder(currentSqr, maze)) return 1;
        int x = currentSqr[0], y = currentSqr[1];

        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};

        if (x-1 >= 0 && !visited.includes(Arrays.asList(left))) {
            return 1 + bfs(maze, visited, left);
        }
        if (y-1 >= 0 && !visited.includes(Arrays.asList(up))) {
            return 1 + bfs(maze, visited, up);
        }
        if (x+1 >= 0 && !visited.includes(Arrays.asList(right))) {
            return 1 + bfs(maze, visited, right);
        }
        if (y+1 >= 0 && !visited.includes(Arrays.asList(down))) {
            return 1 + bfs(maze, visited, down);
        }
    }

    public boolean isBorder(int[] currentSqr, char[][] maze) {
        int x = currentSqr[0], y = currentSqr[1];
        return x == 0 || x == maze.length || y == 0 || y == maze[0].length;
    }
}