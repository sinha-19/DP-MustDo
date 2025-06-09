// Problem: Minimum Coins | DP-20
// Approach: Bottom-up DP (Unbounded)
// Time Complexity: O(n*sum)
// Space Complexity: O(sum)
public class MinimumCoins {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        for (int i = 1; i <= amount; i++) dp[i] = max;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
