class Solution {
    Set<String> visited = new HashSet();
    boolean edgeFound = false;

    public int nearestExit(char[][] maze, int[] entrance) {
        int result = bfs(maze, entrance, entrance);
        return edgeFound ? result : -1;
    }

    public int bfs(char[][] maze, int[] currentSqr, int[] startSqr) {
        int startX = startSqr[0], startY = startSqr[1];
        int x = currentSqr[0], y = currentSqr[1];
        if ((startX != x || startY != y) && isBorder(currentSqr, maze)) {
            edgeFound = true;
            return 0;
        }

        List<Integer> square = Arrays.stream(currentSqr).boxed().toList();
        visited.add(square.toString());
        System.out.print(visited.toString() + ' ');

        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};
        String leftStr = Arrays.stream(left).boxed().toList().toString();
        String rightStr = Arrays.stream(right).boxed().toList().toString();
        String upStr = Arrays.stream(up).boxed().toList().toString();
        String downStr = Arrays.stream(down).boxed().toList().toString();
        System.out.println(maze[x][y]);

        if (x-1 >= 0 && isPath(left, maze) && !visited.contains(leftStr)) {
            int num = 1 + bfs(maze, left, startSqr);
            return num;
        }
        if (y-1 >= 0  && isPath(up, maze) && !visited.contains(upStr)) {
            return 1 + bfs(maze, up, startSqr);
        }
        if (x+1 < maze.length && isPath(right, maze) && !visited.contains(rightStr)) {
            return 1 + bfs(maze, right, startSqr);
        }
        if (y+1 < maze[0].length && isPath(down, maze) && !visited.contains(downStr)) {
            return 1 + bfs(maze, down, startSqr);
        }
        System.out.println("E");
        return -1;
    }

    public boolean isBorder(int[] currentSqr, char[][] maze) {
        int x = currentSqr[0], y = currentSqr[1];
        return x == 0 || x == maze.length-1 || y == 0 || y == maze[0].length-1;
    }

    public boolean isPath(int[] sqr, char[][] maze) {
        return (maze[sqr[0]][sqr[1]] == '.');
    }
}