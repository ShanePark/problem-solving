package shane.leetcode.problems.xhard;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 99.63%
 * Memory 43.8 MB Beats 90.93%
 */
public class Q124BinaryTreeMaximumPathSum {

    @Test
    public void test() {
        assertThat(maxPathSum(TreeNode.of(1, 2, 3))).isEqualTo(6);
        assertThat(maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7))).isEqualTo(42);
    }

    public int maxPathSum(TreeNode root) {
        Max max = new Max();
        maxPathSum(root, max);
        return max.value;
    }

    private int maxPathSum(TreeNode node, Max max) {
        if (node == null)
            return 0;

        int left = Math.max(0, maxPathSum(node.left, max));
        int right = Math.max(0, maxPathSum(node.right, max));

        max.calc(left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    class Max {
        int value = -1000;

        public void calc(int n) {
            this.value = Math.max(value, n);
        }
    }

}
