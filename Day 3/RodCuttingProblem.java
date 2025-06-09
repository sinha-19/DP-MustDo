// Problem: Rod Cutting Problem | DP-24
// Approach: Classic unbounded knapsack
// Time Complexity: O(n*len)
// Space Complexity: O(len)
public class RodCuttingProblem {
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }
        return dp[n];
    }
}
