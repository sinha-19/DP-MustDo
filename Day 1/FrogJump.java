public class FrogJump {
    /*
     * Problem: Min cost to reach end by jumping 1 or 2 steps with height cost
     * Approach: Bottom-up DP using two variables
     * Time: O(n), Space: O(1)
     */
    public int frogJump(int[] heights) {
        int prev1 = 0, prev2 = 0;
        for (int i = 1; i < heights.length; i++) {
            int oneStep = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1)
                twoStep = prev2 + Math.abs(heights[i] - heights[i - 2]);
            int curr = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
