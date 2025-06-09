// File: MatrixChainMultiplicationBottomUp.java
// Problem: Solve MCM using Bottom-Up Tabulation
// Approach: Same as above, just iterative
// Time: O(n^3), Space: O(n^2)
public class MatrixChainMultiplicationBottomUp {
    public int matrixMultiplication(int[] arr, int N) {
        int[][] dp = new int[N][N];
        for (int len = 2; len < N; len++) {
            for (int i = 1; i < N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][N - 1];
    }
}
