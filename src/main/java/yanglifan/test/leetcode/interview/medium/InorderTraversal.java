package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 * <p>
 * 中序遍历二叉树
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.lastElement();
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            } else {
                results.add(stack.pop().val);
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
            }
        }
        return results;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}