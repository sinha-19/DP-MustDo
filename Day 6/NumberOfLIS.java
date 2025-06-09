// Problem: Number of Longest Increasing Subsequences (DP-47)
// Approach: DP with count tracking
// Time Complexity: O(n^2)
// Space Complexity: O(n)
public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++)
            if (dp[i] == maxLen)
                total += count[i];
        return total;
    }
}
