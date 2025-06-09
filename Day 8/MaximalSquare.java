// File: MaximalSquare.java
// Problem: Find the largest square containing only 1s in a binary matrix
// Approach: Bottom-up DP
// Time: O(n*m), Space: O(n*m)
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j],
                                  Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
