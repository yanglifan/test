package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterCombinationsTest {
    private LetterCombinations letterCombinations = new LetterCombinations();

    @Test
    public void test1() {
        List<String> results = letterCombinations.letterCombinations("23");
        assertThat(results).contains("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }
}