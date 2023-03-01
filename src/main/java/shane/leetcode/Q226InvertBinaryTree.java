package shane.leetcode;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40 MB Beats 48.41%
 */
public class Q226InvertBinaryTree {

    @Test
    void test() {
        assertThat(invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9)))
                .isEqualTo(TreeNode.of(4, 7, 2, 9, 6, 3, 1));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

}
