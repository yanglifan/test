package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopKFrequentTest {
    private TopKFrequent sut = new TopKFrequent();

    @Test
    public void test1() {
        int[] results = sut.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertThat(results[0]).isEqualTo(1);
    }
}