package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniquePathsTest {
    private final UniquePaths uniquePaths = new UniquePaths();

    @Test
    public void testStackVersion() {
        int result = uniquePaths.uniquePathsStack(3, 2);
        assertThat(result).isEqualTo(3);

        result = uniquePaths.uniquePathsStack(7, 3);
        assertThat(result).isEqualTo(28);
    }

    @Test
    public void testOfficialVersion() {
        int result = uniquePaths.uniquePaths(3, 2);
        assertThat(result).isEqualTo(3);

        result = uniquePaths.uniquePaths(7, 3);
        assertThat(result).isEqualTo(28);
    }
}