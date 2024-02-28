package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q513FindBottomLeftTreeValue {

    @Test
    public void test() {
        assertThat(findBottomLeftValue(TreeNode.of(2, 1, 3))).isEqualTo(1);
        assertThat(findBottomLeftValue(TreeNode.of(1, 2, 3, 4, null, 5, 6, null, null, 7))).isEqualTo(7);
    }

    int bl = 0;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        bl = root.val;
        maxDepth = 0;
        findBottomLeft(root, 0);
        return bl;
    }

    private void findBottomLeft(TreeNode node, int depth) {
        if (node == null)
            return;
        if (maxDepth < depth) {
            bl = node.val;
            maxDepth = depth;
        }
        findBottomLeft(node.left, depth + 1);
        findBottomLeft(node.right, depth + 1);
    }

}
