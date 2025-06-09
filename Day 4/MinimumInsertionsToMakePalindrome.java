// Problem: Minimum insertions to make string palindrome | DP-29
// Approach: LCS between s and reverse(s), then subtract from length
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
public class MinimumInsertionsToMakePalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (s.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        return n - dp[n][n];
    }
}
