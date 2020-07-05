package yanglifan.test.leetcode.interview.medium;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InorderTraversalTest {
    private InorderTraversal inorderTraversal = new InorderTraversal();

    @Test
    public void test1() {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        n0.right = n1;
        n1.left = new TreeNode(3);

        List<Integer> result = inorderTraversal.inorderTraversal(n0);

        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(3);
        assertThat(result.get(2)).isEqualTo(2);
    }

    @Test
    public void test2() {
        TreeNode n0 = new TreeNode(1);

        List<Integer> result = inorderTraversal.inorderTraversal(n0);

        assertThat(result.get(0)).isEqualTo(1);
    }

    @Test
    public void test3() {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        n0.right = n1;
        TreeNode n2 = new TreeNode(3);
        n1.right = n2;
        n2.right = new TreeNode(4);

        List<Integer> result = inorderTraversal.inorderTraversal(n0);

        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
        assertThat(result.get(3)).isEqualTo(4);
    }

    @Test
    public void test4() {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        n0.left = n1;
        TreeNode n2 = new TreeNode(3);
        n1.left = n2;
        n2.left = new TreeNode(4);

        List<Integer> result = inorderTraversal.inorderTraversal(n0);

        assertThat(result.get(0)).isEqualTo(4);
        assertThat(result.get(1)).isEqualTo(3);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(1);
    }
}