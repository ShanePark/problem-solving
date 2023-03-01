package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 12 ms, faster than 10.40% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 * Memory Usage: 50 MB, less than 38.26% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 */
public class Q235LowestCommonAncestorOfABinarySearchTree2 {

    @Test
    public void test() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left, node.right)).isEqualTo(node);
    }

    @Test
    public void test2() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left, node.left.right)).isEqualTo(node.left);
    }

    @Test
    public void test3() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left.right.right, node.right.left)).isEqualTo(node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return find(root, q, p);
        }
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        int rVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal <= rVal && rVal <= qVal) {
            return root;
        } else if (qVal < rVal) {
            return find(root.left, p, q);
        } else {
            return find(root.right, p, q);
        }
    }
}
