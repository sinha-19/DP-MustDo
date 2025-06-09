// File: BurstBalloons.java
// Problem: Burst balloons to get max coins
// Approach: DP with partitioning the array
// Time: O(n^3), Space: O(n^2)
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 0; i < n; i++) A[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        A[left - 1] * A[k] * A[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
}
