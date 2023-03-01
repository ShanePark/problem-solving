package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2331EvaluateBooleanBinaryTree {

    @Test
    public void test() {
        assertThat(evaluateTree(TreeNode.of(2, 1, 3, null, null, 0, 1))).isTrue();
    }

    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right);
            default:
                return false;
        }
    }

}
