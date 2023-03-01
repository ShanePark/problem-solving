package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q814BinaryTreePruning {

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

    private boolean hasOne(TreeNode root) {
        if (root == null)
            return false;

        boolean left = hasOne(root.left);
        if (!left) {
            root.left = null;
        }

        boolean right = hasOne(root.right);
        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;
    }
}
