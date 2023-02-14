package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q938RangeSumofBST {

    @Test
    void test() {
        Assertions.assertThat(rangeSumBST(TreeNode.ofWithNull(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15)).isEqualTo(32);
        Assertions.assertThat(rangeSumBST(TreeNode.ofWithNull(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 6, 10)).isEqualTo(23);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int sum = (low <= root.val && root.val <= high) ? root.val : 0;

        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }


}
