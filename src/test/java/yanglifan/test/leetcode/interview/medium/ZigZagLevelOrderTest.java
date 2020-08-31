package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ZigZagLevelOrderTest {
    private ZigZagLevelOrder sut = new ZigZagLevelOrder();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(3);
        root.left = t11;
        root.right = t12;
        t11.left = new TreeNode(4);
        t12.right = new TreeNode(5);
        List<List<Integer>> results = sut.zigzagLevelOrder(root);
        assertThat(results.get(2).get(0)).isEqualTo(4);
    }
}