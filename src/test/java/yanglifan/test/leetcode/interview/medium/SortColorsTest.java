package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortColorsTest {
    private SortColors sortColors = new SortColors();

    @Test
    public void test1() {
        int[] array = {2, 0, 2, 1, 1, 0};
        sortColors.sortColorsBubbleSort(array);
        int[] expected = {0, 0, 1, 1, 2, 2};
        assertThat(array).isEqualTo(expected);
    }
}