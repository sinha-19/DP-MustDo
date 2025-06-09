// Problem: Partition Equal Subset Sum | DP-15
// Approach: Subset sum = total / 2
// Time Complexity: O(n*sum/2)
// Space Complexity: O(sum/2)
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] |= dp[j - num];
        return dp[target];
    }
}
