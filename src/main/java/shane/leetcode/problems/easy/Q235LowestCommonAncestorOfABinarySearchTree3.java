package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 * Memory Usage: 43.2 MB, less than 92.73% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 */
@SuppressWarnings("ALL")
public class Q235LowestCommonAncestorOfABinarySearchTree3 {

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
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > qVal) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
            pVal = qVal;
            qVal = q.val;
        }

        while (true) {
            int rVal = root.val;
            if (pVal <= rVal && rVal <= qVal) {
                return root;
            } else if (qVal < rVal) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

}
