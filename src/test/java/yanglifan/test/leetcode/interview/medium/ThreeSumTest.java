package yanglifan.test.leetcode.interview.medium;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumTest {

    @Test
    public void basic() {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> results = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(results.size()).isEqualTo(2);
        results = threeSum.threeSum(new int[]{0, 0, 0, 0});
        assertThat(results.size()).isEqualTo(1);
    }
}