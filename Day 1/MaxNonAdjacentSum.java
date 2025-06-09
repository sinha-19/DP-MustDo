public class MaxNonAdjacentSum {
    /*
     * Problem: Max sum of non-adjacent elements
     * Approach: Bottom-up DP using two variables (include/exclude)
     * Time: O(n), Space: O(1)
     */
    public int maxSum(int[] nums) {
        int include = 0, exclude = 0;
        for (int num : nums) {
            int newInclude = exclude + num;
            exclude = Math.max(include, exclude);
            include = newInclude;
        }
        return Math.max(include, exclude);
    }
}
