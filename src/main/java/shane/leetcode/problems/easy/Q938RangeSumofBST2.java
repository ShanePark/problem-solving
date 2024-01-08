package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime Details 1ms Beats 46.81%of users with Java
 * Memory Details 51.54MB Beats 5.76%of users with Java
 */
public class Q938RangeSumofBST2 {

    @Test
    void test() {
        Assertions.assertThat(rangeSumBST(TreeNode.of(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15)).isEqualTo(32);
        Assertions.assertThat(rangeSumBST(TreeNode.of(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 6, 10)).isEqualTo(23);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int sum = 0;

        sum += rangeSumBST(root.left, low, high);

        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }

        sum += rangeSumBST(root.right, low, high);
        return sum;
    }

}
