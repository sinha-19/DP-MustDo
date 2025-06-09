// File: CountSquareSubmatricesWithAllOnes.java
// Problem: Count all square submatrices with all 1s
// Approach: Bottom-up DP
// Time: O(n*m), Space: O(n*m)
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                      Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    } else {
                        dp[i][j] = 1;
                    }
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}
