class Solution {
    Set<String> visited = new HashSet();

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance, entrance);
    }

    public int bfs(char[][] maze, int[] currentSqr, int[] startSqr) {
        int startX = startSqr[0], startY = startSqr[1];
        int x = currentSqr[0], y = currentSqr[1];
        if ((startX != x || startY != y) && isBorder(currentSqr, maze)) return 0;

        List<Integer> square = Arrays.stream(currentSqr).boxed().toList();
        System.out.print(visited.toString() + ' ');
        visited.add(square.toString());
        System.out.print(visited.toString() + ' ');
        System.out.println((startX != x || startY != y) && isBorder(currentSqr, maze));

        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};
        System.out.println(maze[x][y]);

        if (x-1 >= 0 && isPath(left, maze) && !visited.contains(Arrays.asList(left).toString())) {
            System.out.println("A");
            return 1 + bfs(maze, left, startSqr);
        }
        if (y-1 >= 0  && isPath(up, maze) && !visited.contains(Arrays.asList(up).toString())) {
            System.out.println("B");
            return 1 + bfs(maze, up, startSqr);
        }
        if (x+1 >= 0 && isPath(right, maze) && !visited.contains(Arrays.asList(right).toString())) {
            System.out.println("C");
            return 1 + bfs(maze, right, startSqr);
        }
        if (y+1 >= 0 && isPath(down, maze) && !visited.contains(Arrays.asList(down).toString())) {
            System.out.println("D");
            return 1 + bfs(maze, down, startSqr);
        }
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