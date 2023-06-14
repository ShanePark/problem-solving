package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 43.6 MB Beats 17.96%
 */
public class Q530MinimumAbsoluteDifferenceInBST2 {

    @Test
    public void test() {
        assertThat(getMinimumDifference(TreeNode.of(4, 2, 6, 1, 3))).isEqualTo(1);
        assertThat(getMinimumDifference(TreeNode.of(1, 0, 48, null, null, 12, 49))).isEqualTo(1);
        assertThat(getMinimumDifference(TreeNode.of(236, 104, 701, null, 227, null, 911))).isEqualTo(9);
    }


    int before;
    int minDiff;

    public int getMinimumDifference(TreeNode root) {
        before = -100000;
        minDiff = Integer.MAX_VALUE;
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        minDiff = Math.min(minDiff, root.val - before);
        before = root.val;
        if (root.right != null) {
            dfs(root.right);
        }
    }

}
