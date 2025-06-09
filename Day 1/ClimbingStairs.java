public class ClimbingStairs {
    /*
     * Problem: Count distinct ways to climb n stairs (1 or 2 steps)
     * Approach: Bottom-up DP (Fibonacci-like)
     * Time: O(n), Space: O(n)
     */
    public int climb(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climb(5)); // 8
    }
}
