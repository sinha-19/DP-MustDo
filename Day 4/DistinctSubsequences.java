// Problem: Distinct Subsequences | DP-32
// Approach: Bottom-up DP
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
        return dp[n][m];
    }
}
