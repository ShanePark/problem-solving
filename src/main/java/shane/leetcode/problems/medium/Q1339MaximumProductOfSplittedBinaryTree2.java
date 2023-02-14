package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 76.57%
 * Memory 69.1 MB Beats 49.9%
 */
public class Q1339MaximumProductOfSplittedBinaryTree2 {

    @Test
    public void test() {
        assertThat(maxProduct(TreeNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(110);
        assertThat(maxProduct(TreeNode.of(1, null, 2, 3, 4, null, null, 5, 6))).isEqualTo(90);
    }

    long max;

    public int maxProduct(TreeNode root) {
        max = 0;
        findMax(root, getSum(root));
        return (int) (max % (1e9 + 7));
    }

    private long findMax(TreeNode node, long total) {
        if (node == null)
            return 0;
        long sum = node.val + findMax(node.left, total) + findMax(node.right, total);
        max = Math.max(max, (total - sum) * sum);
        return sum;
    }

    private long getSum(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

}
