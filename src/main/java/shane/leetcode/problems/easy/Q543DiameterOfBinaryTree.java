package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q543DiameterOfBinaryTree {

    @Test
    public void test() {
        assertThat(diameterOfBinaryTree(TreeNode.of(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2))).isEqualTo(8);
        assertThat(diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5))).isEqualTo(3);
        assertThat(diameterOfBinaryTree(TreeNode.of(1, 2))).isEqualTo(1);
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxDistance(root);
        return max;
    }

    private int maxDistance(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftDistance = maxDistance(node.left);
        int rightDistance = maxDistance(node.right);
        max = Math.max(max, leftDistance + rightDistance);
        return Math.max(leftDistance, rightDistance) + 1;
    }

}
