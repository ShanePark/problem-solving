package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 21.43%
 * Memory 53.8 MB Beats 69.94%
 */
public class Q1372LongestZigZagPathInABinaryTree2 {

    @Test
    public void test() {
        assertThat(longestZigZag(TreeNode.of(6, 9, 7, 3, null, 2, 8, 5, 8, 9, 7, 3, 9, 9, 4, 2, 10, null, 5, 4, 3, 10, 10, 9, 4, 1, 2, null, null, 6, 5, null, null, null, null, 9, null, 9, 6, 5, null, 5, null, null, 7, 7, 4, null, 1, null, null, 3, 7, null, 9, null, null, null, null, null, null, null, null, 9, 9, null, null, null, 7, null, null, null, null, null, null, null, null, null, 6, 8, 7, null, null, null, 3, 10, null, null, null, null, null, 1, null, 1, 2)))
                .isEqualTo(5);
        assertThat(longestZigZag(TreeNode.of(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1))).isEqualTo(3);
        assertThat(longestZigZag(TreeNode.of(1, 1, 1, null, 1, null, null, 1, 1, null, 1))).isEqualTo(4);
        assertThat(longestZigZag(TreeNode.of(1))).isEqualTo(0);
    }

    int max = 0;

    public int longestZigZag(TreeNode root) {
        max = 0;
        dfs(root, 0, Direction.LEFT);
        dfs(root, 0, Direction.RIGHT);
        return max;
    }

    public void dfs(TreeNode node, int distance, Direction direction) {
        if (node == null)
            return;
        max = Math.max(max, distance);
        if (direction == Direction.LEFT) {
            dfs(node.right, distance + 1, Direction.RIGHT);
            dfs(node.right, 0, Direction.LEFT);
        }
        if (direction == Direction.RIGHT) {
            dfs(node.left, distance + 1, Direction.LEFT);
            dfs(node.left, 0, Direction.RIGHT);
        }
    }

    enum Direction {
        LEFT, RIGHT
    }

}
