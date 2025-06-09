// Problem: Count Partitions with Given Difference | DP-18
// Approach: Transform into subset sum count
// Time Complexity: O(n*sum)
// Space Complexity: O(sum)
public class CountPartitionsGivenDiff {
    public int countPartitions(int[] nums, int diff) {
        int total = 0;
        for (int num : nums) total += num;
        if ((total - diff) % 2 != 0 || total < diff) return 0;
        int target = (total - diff) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] += dp[j - num];
        return dp[target];
    }
}
