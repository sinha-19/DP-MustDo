// File: LongestIncreasingSubsequence.java
// Problem: Find the length of the Longest Increasing Subsequence
// Approach: Patience Sorting (uses Binary Search to maintain a list)
// Time Complexity: O(n log n)
// Space Complexity: O(n)
import java.util.*;
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // This list will store the smallest tail of all increasing subsequences with different lengths
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            // Find the index where 'num' should be placed
            int idx = Collections.binarySearch(lis, num);
            // If num is not present, binarySearch returns (-(insertion point) - 1)
            if (idx < 0) idx = -idx - 1;
            // If idx is equal to size of list, num is greater than any element in list
            if (idx == lis.size()) {
                lis.add(num);
            } else {
                // Replace existing value to maintain the lowest possible tail value
                lis.set(idx, num);
            }
        }
        // Size of list is the length of LIS
        return lis.size();
    }
    // Example usage
    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + obj.lengthOfLIS(nums));  // Output: 4
    }
}
