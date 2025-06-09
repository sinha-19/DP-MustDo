// Problem: Longest Increasing Subsequence (DP-41)
// Approach: DP + Binary Search (Patience Sorting)
// Time Complexity: O(n log n)
// Space Complexity: O(n)
import java.util.*;
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(temp, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == temp.size()) temp.add(num);
            else temp.set(idx, num);
        }
        return temp.size();
    }
}
