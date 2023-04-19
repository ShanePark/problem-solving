package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 30 ms Beats 10.71%
 * Memory 53.9 MB Beats 57.74%
 */
public class Q1372LongestZigZagPathInABinaryTree {

    @Test
    public void test() {
        assertThat(longestZigZag(TreeNode.of(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1))).isEqualTo(3);
        assertThat(longestZigZag(TreeNode.of(1, 1, 1, null, 1, null, null, 1, 1, null, 1))).isEqualTo(4);
        assertThat(longestZigZag(TreeNode.of(1))).isEqualTo(0);
    }

    int max = 0;

    public int longestZigZag(TreeNode root) {
        max = 0;
        Map<TreeNode, int[]> dp = new HashMap<>();
        dfs(root, dp);
        return max;
    }

    private int[] dfs(TreeNode node, Map<TreeNode, int[]> dp) {
        if (dp.containsKey(node)) {
            return dp.get(node);
        }
        int[] distances = new int[2];
        if (node.left != null) {
            int[] leftWay = dfs(node.left, dp);
            distances[0] = leftWay[1] + 1;
        }
        if (node.right != null) {
            int[] rightWay = dfs(node.right, dp);
            distances[1] = rightWay[0] + 1;
        }
        max = Math.max(max, Math.max(distances[0], distances[1]));
        dp.put(node, distances);
        return distances;
    }

}
