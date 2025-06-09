public class FrogJumpK {
    /*
     * Problem: Min cost to reach end, can jump up to k steps with height cost
     * Approach: Bottom-up DP with array
     * Time: O(n*k), Space: O(n)
     */
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                int cost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                minCost = Math.min(minCost, cost);
            }
            dp[i] = minCost;
        }
        return dp[n - 1];
    }
}
