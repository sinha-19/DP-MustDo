public class HouseRobber {
    /*
     * Problem: Rob houses with no two adjacent
     * Approach: Same as MaxNonAdjacentSum
     * Time: O(n), Space: O(1)
     */
    public int rob(int[] nums) {
        int include = 0, exclude = 0;
        for (int num : nums) {
            int newInclude = exclude + num;
            exclude = Math.max(include, exclude);
            include = newInclude;
        }
        return Math.max(include, exclude);
    }
}
