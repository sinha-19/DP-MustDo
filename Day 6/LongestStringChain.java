// Problem: Longest String Chain (DP-45)
// Approach: Sort + HashMap DP
// Time Complexity: O(n * l^2), l = max word length
// Space Complexity: O(n)
import java.util.*;
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0));
            }
            dp.put(word, best + 1);
            maxLen = Math.max(maxLen, best + 1);
        }
        return maxLen;
    }
}
