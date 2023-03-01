package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1448CountGoodNodesInBinaryTree {

    @Test
    public void test() {
        assertThat(goodNodes(TreeNode.of(3, 1, 4, 3, null, 1, 5))).isEqualTo(4);
        assertThat(goodNodes(TreeNode.of(3,3,null,4,2))).isEqualTo(3);
    }

    int cnt;
    public int goodNodes(TreeNode root) {
        cnt = 0;
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }

    private void dfs(TreeNode node, int max) {
        if(node==null)
            return;
        if(node.val >= max)
            cnt++;
        dfs(node.left, Math.max(max, node.val));
        dfs(node.right, Math.max(max, node.val));
    }
}
