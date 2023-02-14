package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 76.91% of Java online submissions for Count Good Nodes in Binary Tree.
 * Memory Usage: 60.3 MB, less than 20.48% of Java online submissions for Count Good Nodes in Binary Tree.
 */
public class Q1448CountGoodNodesInBinaryTree2 {
    @Test
    public void test() {
        assertThat(goodNodes(TreeNode.ofWithNull(3, 1, 4, 3, null, 1, 5))).isEqualTo(4);
        assertThat(goodNodes(TreeNode.ofWithNull(3, 3, null, 4, 2))).isEqualTo(3);
        assertThat(goodNodes(TreeNode.ofWithNull(1))).isEqualTo(1);
    }

    int cnt;

    public int goodNodes(TreeNode root) {
        cnt = 0;
        dfs(root, root.val);
        return cnt;
    }

    private void dfs(TreeNode node, int val) {
        if (node == null)
            return;
        int cur = node.val;
        if (cur >= val)
            cnt++;
        dfs(node.left, Math.max(val, cur));
        dfs(node.right, Math.max(val, cur));
    }
}
