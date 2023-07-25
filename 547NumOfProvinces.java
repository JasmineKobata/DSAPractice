class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = isConnected.length;
        Set<Integer> indices = new HashSet<Integer>();

        for (int i=0; i < isConnected.length; i++) {
            for (int j=i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && !indices.contains(j)) {
                    indices.add(j);
                    result--;
                }
            }
        }

        return result;
    }
}