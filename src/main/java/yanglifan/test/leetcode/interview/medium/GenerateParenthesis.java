package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

        List<List<String>> all = new LinkedList<>();
        all.add(Collections.singletonList(""));
        all.add(Collections.singletonList("()"));
        for (int i = 2; i <= n; i++) {
            List<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> l1 = all.get(j);
                List<String> l2 = all.get(i - j - 1);
                for (String s1 : l1) {
                    for (String s2 : l2) {
                        temp.add("(" + s1 + ")" + s2);
                    }
                }
            }
            all.add(temp);
        }
        return all.get(n);
    }
}
