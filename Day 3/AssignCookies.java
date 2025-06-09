// Problem: Assign Cookies
// Approach: Greedy sorting
// Time Complexity: O(n log n)
// Space Complexity: O(1)
import java.util.Arrays;
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) i++;
            j++;
        }
        return i;
    }
}
