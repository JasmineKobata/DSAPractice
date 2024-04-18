class Solution {
    public boolean exist(char[][] board, String word) {
        Map<String, Integer> map = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int wordDepthMax = 0;

        for (int x=0; x < board.length; x++) {
            for (int y=0; y < board[0].length; y++) {
                int[] pos = new int[]{x, y};
                if (word.charAt(0) == board[x][y]
                && !map.containsKey(pos.toString())) {
                    q.add(pos);
                    map.put(pos.toString(), 0);
                    if (word.length() == bfs(pos, board, word, map, q)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int bfs(int[] pos, char[][] board, String word, Map<String, Integer> map, Queue<int[]> q) {
        int wordDepthMax = 0;
        while (!q.isEmpty()) {
            int[] elem = q.remove();
            int x = elem[0], y = elem[1];
            int left = x == 0 ? x : x - 1;
            int right = x == board.length - 1 ? x : x + 1;
            int up = y == 0 ?  y : y - 1;
            int down = y == board[0].length - 1 ? y : y + 1;
            for (int dirx = left; dirx <= right; dirx++) {
                for (int diry = up; diry <= down; diry++) {
                    int wordPos = map.get(pos)+1;
                    wordDepthMax = Math.max(wordDepthMax, wordPos);
                    int[] newPos = new int[]{dirx, diry};

                    if (word.charAt(wordPos) == board[dirx][diry]
                    && !map.containsKey(newPos.toString())) {
                        q.add(newPos);
                        map.put(newPos.toString(), wordPos);
                    }
                }
            }
        }
        return wordDepthMax;
    }
}