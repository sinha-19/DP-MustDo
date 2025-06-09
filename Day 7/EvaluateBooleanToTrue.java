// File: EvaluateBooleanToTrue.java
// Problem: Count ways to parenthesize expression so that it evaluates to true
// Approach: Recursion + Memoization
// Time: O(n^3), Space: O(n^2)
import java.util.*;
public class EvaluateBooleanToTrue {
    Map<String, Integer> memo = new HashMap<>();
    public int countWays(String expr) {
        return count(expr, 0, expr.length() - 1, true);
    }
    private int count(String expr, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) return expr.charAt(i) == 'T' ? 1 : 0;
            else return expr.charAt(i) == 'F' ? 1 : 0;
        }
        String key = i + "_" + j + "_" + isTrue;
        if (memo.containsKey(key)) return memo.get(key);
        int ways = 0;
        for (int k = i + 1; k < j; k += 2) {
            char op = expr.charAt(k);
            int lt = count(expr, i, k - 1, true);
            int lf = count(expr, i, k - 1, false);
            int rt = count(expr, k + 1, j, true);
            int rf = count(expr, k + 1, j, false);
            if (op == '&') {
                ways += isTrue ? lt * rt : lt * rf + lf * rt + lf * rf;
            } else if (op == '|') {
                ways += isTrue ? lt * rt + lt * rf + lf * rt : lf * rf;
            } else if (op == '^') {
                ways += isTrue ? lt * rf + lf * rt : lt * rt + lf * rf;
            }
        }
        memo.put(key, ways);
        return ways;
    }
}
