lass Solution {
    public void solve(char[][] board) {
        //BFS - queue
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        for (int x=0; x < board.length; x++) {
            for (int y=0; y < board[x].length; y++) {
                if ((x == 0 || y == 0 || x == board.length-1 || y == board[x].length-1)
                    && board[x][y] == 'O') {
                    q.add(new int[]{x, y});

                    while (!q.isEmpty()) {
                        int[] pos = q.remove();
                        set.add(Arrays.toString(pos));
                        bfs(q, set, board, pos);
                    }
                }
            }
        }

        for (int x=0; x < board.length; x++) {
            for (int y=0; y < board[x].length; y++) {
                int[] pos = new int[]{x, y};
                if (board[x][y] == 'O' && !set.contains(Arrays.toString(pos))) {
                    board[x][y] = 'X';
                }
            }
        }
    }

    private void bfs(Queue<int[]> q, Set<String> set, char[][] board, int[] pos) {
        int x = pos[0], y = pos[1];
        int[] left = new int[]{x-1, y}, right = new int[]{x+1, y};
        int[] up = new int[]{x, y-1}, down = new int[]{x, y+1};
        int[][] dirs = new int[][]{left, right, up, down};
        for (int i=0; i < dirs.length; i++) {
            int[] dpos = dirs[i];
            int dx = dpos[0], dy = dpos[1];
            if (dx >= 0 && dx < board.length
                && dy >= 0 && dy < board[0].length
                && !set.contains(Arrays.toString(pos))
                && board[dx][dy] == 'O') {
                q.add(dirs[i]);
            }
        }
    }
}