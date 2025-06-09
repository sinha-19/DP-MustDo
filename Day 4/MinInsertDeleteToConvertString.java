// Problem: Minimum Insertions/Deletions to Convert String | DP-30
// Approach: LCS(s1, s2), then operations = deletions + insertions
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
public class MinInsertDeleteToConvertString {
    public int minOperations(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        int lcsLen = dp[n][m];
        int deletions = n - lcsLen;
        int insertions = m - lcsLen;
        return deletions + insertions;
    }
}
