// Problem: Wildcard Matching | DP-34
// Approach: Bottom-up DP, '?' = match 1 char, '*' = match 0 or more
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
