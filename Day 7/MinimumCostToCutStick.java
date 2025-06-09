// File: MinimumCostToCutStick.java
// Problem: Cut a stick into pieces at given cuts, minimize total cost
// Approach: Partition DP
// Time: O(n^3), Space: O(n^2)
import java.util.*;
public class MinimumCostToCutStick {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] A = new int[c + 2];
        System.arraycopy(cuts, 0, A, 1, c);
        A[0] = 0;
        A[c + 1] = n;
        Arrays.sort(A);
        int[][] dp = new int[c + 2][c + 2];
        for (int len = 2; len <= c + 1; len++) {
            for (int i = 0; i + len <= c + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], A[j] - A[i] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][c + 1];
    }
}
