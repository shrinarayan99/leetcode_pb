class Solution {

    int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return selection(0, n - 1, piles) > 0;
    }

    public int selection(int i, int j, int[] piles) {

        if (i == j)
            return piles[i];

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int fromStart = piles[i] - selection(i + 1, j, piles);
        int fromEnd = piles[j] - selection(i, j - 1, piles);

        return dp[i][j] = Math.max(fromStart, fromEnd);
    }
}