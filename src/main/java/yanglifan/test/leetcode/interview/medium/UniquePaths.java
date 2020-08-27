package yanglifan.test.leetcode.interview.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目链接：
 * https://leetcode-cn.com/problems/unique-paths/submissions/
 */
public class UniquePaths {
    /**
     * 使用栈的方式实现动态规划
     */
    public int uniquePathsStack(int m, int n) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{0, 0});
        int result = 0;
        while (!stack.empty()) {
            Integer[] point = stack.pop();
            if (point[0] == m - 1 && point[1] == n - 1) {
                result++;
            } else {
                if (point[0] <= m - 1) {
                    stack.push(new Integer[]{point[0] + 1, point[1]});
                }

                if (point[1] <= n - 1) {
                    stack.push(new Integer[]{point[0], point[1] + 1});
                }
            }
        }
        return result;
    }

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
