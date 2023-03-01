package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 39.7 MB Beats 94.23%
 */
public class Q965UnivaluedBinaryTree {

    @Test
    public void test() {
        assertThat(isUnivalTree(TreeNode.of(1, 1))).isTrue();
        assertThat(isUnivalTree(TreeNode.of(1, 1, 1, 1, 1, null, 1))).isTrue();
        assertThat(isUnivalTree(TreeNode.of(2, 2, 2, 5, 2))).isFalse();
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null && (root.val != root.left.val || !isUnivalTree(root.left))) {
            return false;
        }
        if (root.right != null && (root.val != root.right.val || !isUnivalTree(root.right))) {
            return false;
        }
        return true;
    }

}
