package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.5 MB Beats 59.97%
 */
public class Q101SymmetricTree {

    @Test
    public void test() {
        assertThat(isSymmetric(TreeNode.of(1, 2, 2, 3, 4, 4, 3))).isTrue();
        assertThat(isSymmetric(TreeNode.of(1, 2, 2, null, 3, null, 3))).isFalse();
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left == null ? null : left.val) != (right == null ? null : right.val)) {
            return false;
        }
        if (left == null)
            return true;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
