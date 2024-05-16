package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q2331EvaluateBooleanBinaryTree2 {

    @Test
    public void test() {
        assertThat(evaluateTree(TreeNode.of(2, 1, 3, null, null, 0, 1))).isTrue();
        assertThat(evaluateTree(TreeNode.of(0))).isFalse();
    }

    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
        throw new RuntimeException();
    }

}
