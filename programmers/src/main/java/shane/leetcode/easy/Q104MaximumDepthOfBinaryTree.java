package shane.leetcode.easy;

public class Q104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(max(root.left, 1), max(root.right, 1));
    }

    public int max(TreeNode root, int depth) {
        if (root == null)
            return depth;
        else
            return Math.max(max(root.left, depth + 1), max(root.right, depth + 1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}


