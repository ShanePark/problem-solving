package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 91.29% of Java online submissions for Reverse Odd Levels of Binary Tree.
 * Memory Usage: 71.9 MB, less than 79.38% of Java online submissions for Reverse Odd Levels of Binary Tree.
 */
public class Q2415ReverseOddLevelsOfBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNode.of(2, 3, 5, 8, 13, 21, 34);
        root.printTree();

        TreeNode result = reverseOddLevels(root);
        result.printTree();
        assertThat(result).isEqualTo(TreeNode.of(2, 5, 3, 8, 13, 21, 34));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.of(0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2);
        root.printTree();

        TreeNode result = reverseOddLevels(root);
        result.printTree();
        assertThat(result).isEqualTo(TreeNode.of(0, 2, 1, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1));
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        traverse(root.left, root.right, true);
        return root;
    }

    public void traverse(TreeNode node1, TreeNode node2, boolean change) {
        if (node1 == null)
            return;

        if (change) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        traverse(node1.left, node2.right, !change);
        traverse(node1.right, node2.left, !change);
    }


}
