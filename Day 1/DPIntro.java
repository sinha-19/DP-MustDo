public class DPIntro {
    /*
     * Problem: Introduction to dynamic programming – implement Fibonacci with memoization
     * Approach: Top-down DP with memo array to avoid redundant recursion
     * Time: O(n), Space: O(n) for memo + recursion stack
     */
    private int[] memo;
    public int fib(int n) {
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        return dfs(n);
    }
    private int dfs(int n) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = dfs(n - 1) + dfs(n - 2);
        return memo[n];
    }
    // Test
    public static void main(String[] args) {
        DPIntro d = new DPIntro();
        System.out.println(d.fib(10)); // 55
    }
}
