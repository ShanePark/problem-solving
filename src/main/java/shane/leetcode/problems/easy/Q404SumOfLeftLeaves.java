package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q404SumOfLeftLeaves {

    @Test
    public void test() {
        assertThat(sumOfLeftLeaves(TreeNode.of(3, 9, 20, null, null, 15, 7))).isEqualTo(24);
        assertThat(sumOfLeftLeaves(TreeNode.of(1))).isEqualTo(0);
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        sumLeftLeaves(root.left, true);
        sumLeftLeaves(root.right, false);
        return sum;
    }

    void sumLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (isLeft) {
                sum += node.val;
            }
            return;
        }
        sumLeftLeaves(node.left, true);
        sumLeftLeaves(node.right, false);
    }

}
