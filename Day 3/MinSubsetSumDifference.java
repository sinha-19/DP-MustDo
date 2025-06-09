// Problem: Partition Set Into 2 Subsets With Min Absolute Sum Diff | DP-16
// Approach: Use subset sum and minimize |S1 - S2|
// Time Complexity: O(n*sum)
// Space Complexity: O(sum)
public class MinSubsetSumDifference {
    public int minDifference(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums)
            for (int j = sum; j >= num; j--)
                dp[j] |= dp[j - num];
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++)
            if (dp[s1])
                minDiff = Math.min(minDiff, Math.abs(sum - 2 * s1));
        return minDiff;
    }
}
