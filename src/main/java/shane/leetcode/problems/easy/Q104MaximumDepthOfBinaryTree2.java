package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41.9 MB Beats 76.1%
 */
public class Q104MaximumDepthOfBinaryTree2 {

    @Test
    public void test() {
        assertThat(maxDepth(TreeNode.of(3, 9, 20, null, null, 15, 7))).isEqualTo(3);
        assertThat(maxDepth(null)).isEqualTo(0);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null)
            return depth;
        return Math.max(maxDepth(node.right, depth + 1), maxDepth(node.left, depth + 1));
    }

}
