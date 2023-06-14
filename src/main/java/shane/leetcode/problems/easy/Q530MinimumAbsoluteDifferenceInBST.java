package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 36.16%
 * Memory 43.3 MB Beats 36.27%
 */
public class Q530MinimumAbsoluteDifferenceInBST {

    @Test
    public void test() {
        assertThat(getMinimumDifference(TreeNode.of(4, 2, 6, 1, 3))).isEqualTo(1);
        assertThat(getMinimumDifference(TreeNode.of(1, 0, 48, null, null, 12, 49))).isEqualTo(1);
        assertThat(getMinimumDifference(TreeNode.of(236, 104, 701, null, 227, null, 911))).isEqualTo(9);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(minDiff, list.get(i + 1) - list.get(i));
        }

        return minDiff;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

}
