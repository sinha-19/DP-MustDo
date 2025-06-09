// Problem: Best Time to Buy and Sell Stock with Transaction Fee | DP-32
// Approach: Track buy/sell states with fee applied
// Time Complexity: O(n)
// Space Complexity: O(1)
public class BestTimeToBuySellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prevBuy + prices[i] - fee);
        }
        return sell;
    }
}
