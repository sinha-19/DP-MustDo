// Problem: Shortest Common Supersequence | DP-31
// Approach: Build LCS, merge strings around LCS
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        StringBuilder res = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                res.append(s1.charAt(i-1));
                i--; j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                res.append(s1.charAt(i-1));
                i--;
            } else {
                res.append(s2.charAt(j-1));
                j--;
            }
        }
        while (i > 0) res.append(s1.charAt(i-- - 1));
        while (j > 0) res.append(s2.charAt(j-- - 1));
        return res.reverse().toString();
    }
}
