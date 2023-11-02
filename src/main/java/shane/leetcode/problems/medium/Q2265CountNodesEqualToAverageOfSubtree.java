package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 43.46MB Beats 17.60%of users with Java
 */
public class Q2265CountNodesEqualToAverageOfSubtree {

    @Test
    public void test() {
        assertThat(averageOfSubtree(TreeNode.of(4, 8, 5, 0, 1, null, 6))).isEqualTo(5);
        assertThat(averageOfSubtree(TreeNode.of(1))).isEqualTo(1);
    }

    int answer;

    public int averageOfSubtree(TreeNode root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int cnt = 1 + left[0] + right[0];
        int sum = node.val + left[1] + right[1];
        if (sum / cnt == node.val) {
            answer++;
        }
        return new int[]{cnt, sum};
    }

}
