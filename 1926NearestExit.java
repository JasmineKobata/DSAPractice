class Solution {
    Set<String> visited = new HashSet();

    public int nearestExit(char[][] maze, int[] entrance) {
        System.out.println("Start: " + maze.toString());
        int result = bfs(maze, entrance, entrance);
        System.out.println("End: " + result);
        return result;
    }

    public int bfs(char[][] maze, int[] currentSqr, int[] startSqr) {
        System.out.println("VIS: " + visited.toString() + ' ');
        int startX = startSqr[0], startY = startSqr[1];
        int x = currentSqr[0], y = currentSqr[1];
        if ((startX != x || startY != y) && isBorder(currentSqr, maze)) {
            System.out.println("Z");
            return 0;
        }

        List<Integer> square = Arrays.stream(currentSqr).boxed().toList();
        visited.add(square.toString());
        System.out.print(visited.toString() + ' ');

        int[] left = new int[]{x-1, y};
        int[] right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1};
        int[] down = new int[]{x, y+1};
        System.out.println(maze[x][y]);

        if (x-1 >= 0 && isPath(left, maze) && !visited.contains(Arrays.asList(left).toString())) {
            System.out.println("A " + visited.toString());
            int num = 1 + bfs(maze, left, startSqr);
            System.out.println("A " + num);
            return num;
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