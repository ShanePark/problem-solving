package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 39.6 MB Beats 92.86%
 */
public class Q783MinimumDistanceBetweenBSTNodes {

    @Test
    public void test() {
        assertThat(minDiffInBST(TreeNode.of(4, 2, 6, 1, 3))).isEqualTo(1);
        assertThat(minDiffInBST(TreeNode.of(1, 0, 48, null, null, 12, 49))).isEqualTo(1);
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(minDiff, list.get(i + 1) - list.get(i));
        }
        return minDiff;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
