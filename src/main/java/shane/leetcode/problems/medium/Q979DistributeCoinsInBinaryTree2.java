package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q979DistributeCoinsInBinaryTree2 {

    @Test
    public void test() {
        assertThat(distributeCoins(TreeNode.of(3, 0, 0))).isEqualTo(2);
        assertThat(distributeCoins(TreeNode.of(0, 3, 0))).isEqualTo(3);
        assertThat(distributeCoins(TreeNode.of(1, 0, 0, null, 3))).isEqualTo(4);
    }

    int answer;

    public int distributeCoins(TreeNode root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int required = dfs(node.left) + dfs(node.right) + 1 - node.val;
        answer += Math.abs(required);
        return required;
    }

}
