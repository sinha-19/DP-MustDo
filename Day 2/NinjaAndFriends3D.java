/*
Problem: 3-D DP: Ninja and his Friends (DP-13)
Approach: Top-Down 3D DP with recursion and memoization.
Time Complexity: O(n * m * m)
*/
public class NinjaAndFriends3D {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int[][] row : dp) for (int[] col : row) Arrays.fill(col, -1);
        return helper(0, 0, c - 1, grid, dp);
    }
    private static int helper(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int m = grid[0].length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return Integer.MIN_VALUE;
        if (i == grid.length - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int next = helper(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                if (j1 == j2) next += grid[i][j1];
                else next += grid[i][j1] + grid[i][j2];
                max = Math.max(max, next);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
