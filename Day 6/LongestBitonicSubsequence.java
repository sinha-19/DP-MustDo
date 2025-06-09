// Problem: Longest Bitonic Subsequence (DP-46)
// Approach: LIS from left and right
// Time Complexity: O(n^2)
// Space Complexity: O(n)
public class LongestBitonicSubsequence {
    public int longestBitonic(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j > i; j--)
                if (nums[j] < nums[i])
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++)
            maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
        return maxLen;
    }
}
