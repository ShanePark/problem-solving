package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 69.13% of Java online submissions for Path Sum.
 * Memory Usage: 43.6 MB, less than 59.51% of Java online submissions for Path Sum.
 */
public class Q112PathSum {

    @Test
    public void test() {
        assertThat(hasPathSum(null, 0)).isFalse();
        TreeNode root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1);
        assertThat(hasPathSum(root, 22)).isTrue();
        TreeNode root2 = TreeNode.of(1, 2, 3);
        assertThat(hasPathSum(root2, 5)).isFalse();
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int val = root.val;
        if (targetSum == val && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum - val) || hasPathSum(root.right, targetSum - val);
    }

}
