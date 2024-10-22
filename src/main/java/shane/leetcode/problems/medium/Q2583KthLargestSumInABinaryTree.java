package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime55msBeats5.51%
 */
public class Q2583KthLargestSumInABinaryTree {

    @Test
    public void test() {
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7, 4, 6), 2)).isEqualTo(13);
        assertThat(kthLargestLevelSum(TreeNode.of(1, 2, null, 3), 1)).isEqualTo(3);
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7), 4)).isEqualTo(-1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> sums = new HashMap<>();
        traverse(root, sums, 0);
        if (sums.size() < k)
            return -1;
        List<Long> list = sums.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());
        return list.get(k - 1);
    }

    private void traverse(TreeNode root, Map<Integer, Long> sums, int depth) {
        if (root == null)
            return;
        sums.merge(depth, (long) root.val, Long::sum);
        traverse(root.left, sums, depth + 1);
        traverse(root.right, sums, depth + 1);
    }

}
