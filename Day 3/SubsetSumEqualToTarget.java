// Problem: Subset Sum Equal To Target | DP-14
// Approach: Bottom-up DP on 1D array
// Time Complexity: O(n*target)
// Space Complexity: O(target)
public class SubsetSumEqualToTarget {
    public boolean isSubsetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
