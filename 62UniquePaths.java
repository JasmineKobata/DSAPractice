class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) { dp[i][0] = 1; }
        for (int i=0; i<n; i++) { dp[0][i] = 1; }

        for (int y=1; y<m; y++) {
            for (int x=1; x<n; x++) {
                dp[y][x] = dp[y-1][x] + dp[y][x-1];
            }
        }

        return dp[m-1][n-1];
    }
}