package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 84.03% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
 * Memory Usage: 44.2 MB, less than 71.67% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
 */
public class Q1123LowestCommonAncestorOfDeepestLeaves2 {

    @Test
    public void test() {
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))).isEqualTo(TreeNode.ofWithNull(2, 7, 4));
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(1))).isEqualTo(TreeNode.ofWithNull(1));
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(0, 1, 3, null, 2))).isEqualTo(TreeNode.ofWithNull(2));
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        } else {
            return (leftDepth > rightDepth) ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
        }
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

}
