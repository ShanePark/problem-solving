package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;

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

}


