// Problem: Target Sum | DP-21
// Approach: Convert to subset sum (like CountPartitionsGivenDiff)
// Time Complexity: O(n*sum)
// Space Complexity: O(sum)
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;
        if ((total + target) % 2 != 0 || total < Math.abs(target)) return 0;
        int sum = (total + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int j = sum; j >= num; j--)
                dp[j] += dp[j - num];
        return dp[sum];
    }
}
