// Problem: Best Time to Buy and Sell Stock I | DP-28
// Approach: Track min price, maximize profit
// Time Complexity: O(n)
// Space Complexity: O(1)
public class BestTimeToBuySellStock1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
