// Problem: Best Time to Buy and Sell Stock II | DP-29
// Approach: Greedy accumulate profits on every rise
// Time Complexity: O(n)
// Space Complexity: O(1)
public class BestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}
