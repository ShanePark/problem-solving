package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 76.91% of Java online submissions for Count Good Nodes in Binary Tree.
 * Memory Usage: 59 MB, less than 81.81% of Java online submissions for Count Good Nodes in Binary Tree.
 */
public class Q1448CountGoodNodesInBinaryTree3 {
    @Test
    public void test() {
        assertThat(goodNodes(TreeNode.ofWithNull(3, 1, 4, 3, null, 1, 5))).isEqualTo(4);
        assertThat(goodNodes(TreeNode.ofWithNull(3, 3, null, 4, 2))).isEqualTo(3);
        assertThat(goodNodes(TreeNode.ofWithNull(1))).isEqualTo(1);
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int val) {
        int answer = 0;
        int cur = node.val;
        if (cur >= val)
            answer++;

        if (node.left != null) {
            answer += dfs(node.left, Math.max(val, cur));
        }
        if (node.right != null) {
            answer += dfs(node.right, Math.max(val, cur));
        }

        return answer;
    }
}
