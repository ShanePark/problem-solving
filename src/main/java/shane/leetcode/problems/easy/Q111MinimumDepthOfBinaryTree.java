package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 32.99%
 * Memory 62.7 MB Beats 23.56%
 */
public class Q111MinimumDepthOfBinaryTree {

    @Test
    void test() {
        assertThat(minDepth(null)).isEqualTo(0);
        assertThat(minDepth(TreeNode.of(2, null, 3, null, 4, null, 5, null, 6))).isEqualTo(5);
        assertThat(minDepth(TreeNode.of(3, 9, 20, null, null, 15, 7))).isEqualTo(2);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null)
            return depth;
        int left = node.left == null ? Integer.MAX_VALUE : dfs(node.left, depth + 1);
        int right = node.right == null ? Integer.MAX_VALUE : dfs(node.right, depth + 1);
        return Math.min(left, right);
    }

}
