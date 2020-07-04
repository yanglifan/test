package yanglifan.test.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, left, mid - 1);
        node.right = makeTree(nums, mid + 1, right);
        return node;
    }
}