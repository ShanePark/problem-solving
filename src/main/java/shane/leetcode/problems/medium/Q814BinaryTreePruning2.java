package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
 * Memory Usage: 41.2 MB, less than 80.11% of Java online submissions for Binary Tree Pruning.
 */
public class Q814BinaryTreePruning2 {

    @Test
    public void test() {
        TreeNode start = TreeNode.of(1, null, 0, null, null, 0, 1);
        TreeNode end = pruneTree(start);
        assertThat(end).isEqualTo(TreeNode.of(1, null, 0, null, null, null, 1));
    }

    @Test
    public void test2() {
        TreeNode start = TreeNode.of(0, null, 0, null, null, 0, 0);
        TreeNode end = pruneTree(start);
        assertThat(end).isNull();
    }

    public TreeNode pruneTree(TreeNode root) {
        return hasOne(root) ? root : null;
    }

    public boolean hasOne(TreeNode node) {
        if (node == null)
            return false;
        node.left = hasOne(node.left) ? node.left : null;
        node.right = hasOne(node.right) ? node.right : null;
        return node.val == 1 || node.left != null || node.right != null;
    }

}
