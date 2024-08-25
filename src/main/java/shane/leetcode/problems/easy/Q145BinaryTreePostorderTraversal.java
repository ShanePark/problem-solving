package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q145BinaryTreePostorderTraversal {

    @Test
    public void test() {
        assertThat(postorderTraversal(TreeNode.of(1, null, 2, 3))).containsExactly(3, 2, 1);
        assertThat(postorderTraversal(null)).containsExactly();
        assertThat(postorderTraversal(TreeNode.of(1))).containsExactly(1);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postOrder(answer, root);
        return answer;
    }

    private void postOrder(List<Integer> answer, TreeNode node) {
        if (node == null)
            return;
        postOrder(answer, node.left);
        postOrder(answer, node.right);
        answer.add(node.val);
    }

}
