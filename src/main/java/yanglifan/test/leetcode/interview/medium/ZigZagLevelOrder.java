package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历，https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> layer = new ArrayList<>();
        Stack<TreeNode> layerStack = new Stack<>();
        int level = 0;

        List<List<Integer>> results = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            layer.add(node.val);

            if (level % 2 == 1) {
                if (node.right != null) {
                    layerStack.push(node.right);
                }

                if (node.left != null) {
                    layerStack.push(node.left);
                }
            } else {
                if (node.left != null) {
                    layerStack.push(node.left);
                }

                if (node.right != null) {
                    layerStack.add(node.right);
                }
            }

            if (stack.isEmpty() && !layer.isEmpty()) {
                level++;
                stack = layerStack;
                layerStack = new Stack<>();

                results.add(layer);
                layer = new ArrayList<>();
            }
        }

        return results;
    }
}
