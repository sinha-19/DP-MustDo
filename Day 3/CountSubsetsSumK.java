// Problem: Count Subsets with Sum K | DP-17
// Approach: Bottom-up tabulation
// Time Complexity: O(n*target)
// Space Complexity: O(target)
public class CountSubsetsSumK {
    public int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] += dp[j - num];
        return dp[target];
    }
}
