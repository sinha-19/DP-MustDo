// Problem: Best Time to Buy and Sell Stock with Cooldown | DP-31
// Approach: DP with three states (buy, sell, cooldown)
// Time Complexity: O(n)
// Space Complexity: O(n)
public class BestTimeToBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] sell = new int[n];
        int[] buy = new int[n];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[n - 1];
    }
}
