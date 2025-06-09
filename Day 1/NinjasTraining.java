/*
Problem: Ninja's Training (DP-7)
Approach: Top-Down DP with memoization. For each day and task, choose the best among tasks not equal to previous day’s task.
Time Complexity: O(N)
*/
public class NinjasTraining {
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(n - 1, 3, points, dp);
    }
    private static int f(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) max = Math.max(max, points[0][i]);
            }
            return max;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[day][i] + f(day - 1, i, points, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }
}
