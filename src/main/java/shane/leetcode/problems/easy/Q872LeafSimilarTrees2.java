package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 26.62%of users with Java
 * Memory Details 41.26MB Beats 28.11%of users with Java
 */
public class Q872LeafSimilarTrees2 {

    @Test
    public void test() {
        assertThat(leafSimilar(
                TreeNode.of(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
                , TreeNode.of(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)))
                .isTrue();
        assertThat(leafSimilar(
                TreeNode.of(1, 2, 3)
                , TreeNode.of(1, 3, 2)))
                .isFalse();
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);
        int size = leaves1.size();
        if (size != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
                continue;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return leaves;
    }

}
