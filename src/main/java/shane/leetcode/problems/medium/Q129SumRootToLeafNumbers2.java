package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q129SumRootToLeafNumbers2 {

    @Test
    public void test() {
        assertThat(sumNumbers(TreeNode.of(1, 2, 3))).isEqualTo(25);
        assertThat(sumNumbers(TreeNode.of(4, 9, 0, 5, 1))).isEqualTo(1026);
    }

    int answer = 0;

    public int sumNumbers(TreeNode root) {
        answer = 0;
        sum(root, 0);
        return answer;
    }

    private void sum(TreeNode node, int sum) {
        if (node == null)
            return;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            answer += sum;
            return;
        }
        sum(node.left, sum);
        sum(node.right, sum);
    }

}
