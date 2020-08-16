package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv8ka1/
 * <p>
 * TODO 未提交
 */
public class LetterCombinations {
    private final List<String> results = new ArrayList<>();
    private final Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);
        return results;
    }

    private void backtrack(String combinations, String digits) {
        if (digits.length() == 0) {
            if (combinations.length() > 0) {
                results.add(combinations);
            }
            return;
        }

        String digit = digits.substring(0, 1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            backtrack(combinations + letter, digits.substring(1));
        }
    }
}
