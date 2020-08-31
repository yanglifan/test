package yanglifan.test.leetcode.interview.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> layer = new ArrayList<>();
        Queue<TreeNode> layerQueue = new LinkedList<>();
        int level = 0;

        List<List<Integer>> results = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            layer.add(node.val);

            if (level % 2 == 0) {
                if (node.right != null) {
                    layerQueue.add(node.right);
                }

                if (node.left != null) {
                    layerQueue.add(node.left);
                }
            } else {
                if (node.left != null) {
                    layerQueue.add(node.left);
                }

                if (node.right != null) {
                    layerQueue.add(node.right);
                }
            }

            if (queue.isEmpty() && !layerQueue.isEmpty()) {
                level++;
                queue = layerQueue;
                layerQueue = new LinkedList<>();

                results.add(layer);
                layer = new ArrayList<>();
            }
        }

        return results;
    }
}
