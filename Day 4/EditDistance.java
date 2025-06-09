// Problem: Edit Distance | DP-33
// Approach: Bottom-up DP (Insert, Remove, Replace)
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class EditDistance {
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], 
                                    Math.min(dp[i][j-1], dp[i-1][j]));
        return dp[n][m];
    }
}
