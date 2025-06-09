/*
Problem: Minimum/Maximum Falling Path Sum (DP-12)
Approach: Bottom-Up DP from second-last row to top.
Time Complexity: O(n*n)
*/
public class MinMaxFallingPath {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int left = j > 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(down, Math.min(left, right));
            }
        }
        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
