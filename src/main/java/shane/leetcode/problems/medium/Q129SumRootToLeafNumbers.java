package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.6 MB Beats 21.63%
 */
public class Q129SumRootToLeafNumbers {

    @Test
    public void test() {
        assertThat(sumNumbers(TreeNode.of(1, 2, 3))).isEqualTo(25);
        assertThat(sumNumbers(TreeNode.of(4, 9, 0, 5, 1))).isEqualTo(1026);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int val = root.val;
        sum = sum * 10 + val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

}
