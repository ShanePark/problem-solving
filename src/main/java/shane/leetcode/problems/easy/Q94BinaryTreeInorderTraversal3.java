package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 40.88MB Beats 36.68%of users with Java
 */
public class Q94BinaryTreeInorderTraversal3 {

    @Test
    public void test() {
        assertThat(inorderTraversal(TreeNode.of(2, 3, null, 1))).containsExactly(1, 3, 2);
        assertThat(inorderTraversal(null)).isEmpty();
        assertThat(inorderTraversal(TreeNode.of(1))).containsExactly(1);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        dfsInOrder(answer, root);
        return answer;
    }

    private void dfsInOrder(List<Integer> answer, TreeNode node) {
        if (node == null)
            return;
        dfsInOrder(answer, node.left);
        answer.add(node.val);
        dfsInOrder(answer, node.right);
    }

}
