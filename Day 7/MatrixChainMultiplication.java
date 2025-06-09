// File: MatrixChainMultiplication.java
// Problem: Given dimensions of matrices, find the minimum number of multiplications needed
// Approach: Top-Down Recursive DP (Memoization)
// Time: O(n^3), Space: O(n^2)
public class MatrixChainMultiplication {
    public int matrixMultiplication(int[] arr, int N) {
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N - 1];
    }
}
