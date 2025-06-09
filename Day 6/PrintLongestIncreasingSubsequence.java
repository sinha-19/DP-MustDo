// Problem: Printing Longest Increasing Subsequence (DP-42)
// Approach: DP with backtracking
// Time Complexity: O(n^2)
// Space Complexity: O(n)
import java.util.*;
public class PrintLongestIncreasingSubsequence {
    public List<Integer> getLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) hash[i] = i;
        int maxLen = 1, lastIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> lis = new ArrayList<>();
        while (hash[lastIndex] != lastIndex) {
            lis.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        lis.add(nums[lastIndex]);
        Collections.reverse(lis);
        return lis;
    }
}
