// Problem: Longest Palindromic Subsequence | DP-28
// Approach: LCS between s and reverse(s)
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (s.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[n][n];
    }
}
