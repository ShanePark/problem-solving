package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q1325DeleteLeavesWithAGivenValue2 {

    @Test
    public void test() {
        assertThat(removeLeafNodes(TreeNode.of(1, 2, 3, 2, null, 2, 4), 2)).isEqualTo(TreeNode.of(1, null, 3, null, 4));
        assertThat(removeLeafNodes(TreeNode.of(1, 3, 3, 3, 2), 3)).isEqualTo(TreeNode.of(1, 3, null, null, 2));
        assertThat(removeLeafNodes(TreeNode.of(1, 2, null, 2, null, 2), 2)).isEqualTo(TreeNode.of(1));
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null)
            return null;
        return root;
    }

}
