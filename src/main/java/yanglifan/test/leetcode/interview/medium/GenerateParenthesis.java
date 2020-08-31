package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号生成，https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return Collections.singletonList("()");
        }

        Set<String> results = new HashSet<>();
        results.add("()");
        for (int i = 2; i <= n; i++) {
            Set<String> newResults = new HashSet<>();
            for (String base : results) {
                newResults.add("(" + base + ")");
                newResults.add("()" + base);
                newResults.add(base + "()");
            }
            results = newResults;
        }
        return new ArrayList<>(results);
    }
}
