package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q1026MaximumDifferenceBetweenNodeAndAncestor2 {

    @Test
    public void test() {
        assertThat(maxAncestorDiff(TreeNode.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13))).isEqualTo(7);
        assertThat(maxAncestorDiff(TreeNode.of(1, null, 2, null, 0, 3))).isEqualTo(3);
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    private int maxAncestorDiff(TreeNode node, int max, int min) {
        if (node == null)
            return 0;
        int cur = node.val;
        int diffMax = Math.abs(cur - max);
        int diffMin = Math.abs(cur - min);
        int value = Math.max(diffMax, diffMin);
        max = Math.max(max, cur);
        min = Math.min(min, cur);
        int left = maxAncestorDiff(node.left, max, min);
        int right = maxAncestorDiff(node.right, max, min);
        return Math.max(Math.max(value, left), right);
    }

}
