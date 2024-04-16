package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q623AddOneRowToTree2 {

    @Test
    public void test() {
        assertThat(addOneRow(TreeNode.of(4, 2, 6, 3, 1, 5), 1, 2)).isEqualTo(TreeNode.of(4,1,1,2,null,null,6,3,1,5));
        assertThat(addOneRow(TreeNode.of(4, 2, null, 3, 1), 1, 3)).isEqualTo(TreeNode.of(4,2,null,1,1,3,null,null,1));
        assertThat(addOneRow(TreeNode.of(2), 1, 1)).isEqualTo(TreeNode.of(1, 2));
        assertThat(addOneRow(TreeNode.of(1, 2, 3, 4), 5, 4)).isEqualTo(TreeNode.of(1, 2, 3, 4, null, null, null, 5, 5));
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        traverse(root, 1, val, depth, true);
        return root;
    }

    private TreeNode traverse(TreeNode node, int curDepth, int val, int depth, boolean isLeft) {
        if (curDepth == depth) {
            if (node == null) {
                return new TreeNode(val);
            }
            TreeNode child = new TreeNode(node.val);
            node.val = val;
            child.left = node.left;
            child.right = node.right;
            if (isLeft) {
                node.left = child;
                node.right = null;
            } else {
                node.right = child;
                node.left = null;
            }
            return node;
        }
        if (node != null) {
            node.left = traverse(node.left, curDepth + 1, val, depth, true);
            node.right = traverse(node.right, curDepth + 1, val, depth, false);
        }
        return node;
    }

}
