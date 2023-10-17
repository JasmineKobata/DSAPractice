class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int x=0; x<text1.length(); x++) {
            dp[x][0] = text1.charAt(x) == text2.charAt(0) ? 1 : 0;
        }
        for (int y=0; y<text2.length(); y++) {
            dp[0][y] = text2.charAt(y) == text1.charAt(0) ? 1 : 0;
        }

        for (int x=1; x<text1.length(); x++) {
            for (int y=1; y<text2.length(); y++) {
                if (text1.charAt(x) == text2.charAt(y))
                    dp[x][y] = dp[x-1][y-1] + 1;
                else
                    dp[x][y] = dp[x-1][y-1];
            }
        }

        System.out.println(dp);

        return dp[text1.length()-1][text2.length()-1];
    }
}