package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 18.6%
 * Memory 45.8 MB Beats 80.7%
 */
public class Q1161MaximumLevelSumOfABinaryTree {

    @Test
    public void test() {
        assertThat(maxLevelSum(TreeNode.of(1, 7, 0, 7, -8, null, null))).isEqualTo(2);
        assertThat(maxLevelSum(TreeNode.of(989, null, 10250, 98693, -89388, null, null, null, -32127))).isEqualTo(2);
    }

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sumByDepth = new LinkedHashMap<>();
        dfs(root, sumByDepth, 1);
        Integer maxDepth = sumByDepth.keySet().stream().max(Comparator.naturalOrder()).get();
        int maxValue = Integer.MIN_VALUE;
        int minDepth = 0;
        for (int i = 1; i <= maxDepth; i++) {
            Integer sum = sumByDepth.get(i);
            if (sum > maxValue) {
                maxValue = sum;
                minDepth = i;
            }
        }
        return minDepth;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> sumByDepth, int depth) {
        if (root == null)
            return;
        sumByDepth.merge(depth, root.val, Integer::sum);
        dfs(root.left, sumByDepth, depth + 1);
        dfs(root.right, sumByDepth, depth + 1);
    }

}
