// File: MaximalRectangleArea.java
// Problem: Find the largest rectangle with all 1's in a binary matrix
// Approach: Histogram + stack (like largest rectangle in histogram)
// Time: O(n * m), Space: O(m)
public class MaximalRectangleArea {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, getMaxArea(heights));
        }
        return maxArea;
    }
    private int getMaxArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (right[i] - left[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
