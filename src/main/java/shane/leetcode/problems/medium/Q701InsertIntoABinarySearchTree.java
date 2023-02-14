package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q701InsertIntoABinarySearchTree {

    @Test
    public void test() {
        assertThat(insertIntoBST(TreeNode.ofWithNull(4, 2, 7, 1, 3), 5)).isEqualTo(TreeNode.ofWithNull(4, 2, 7, 1, 3, 5));
        assertThat(insertIntoBST(TreeNode.ofWithNull(40, 20, 60, 10, 30, 50, 70), 25)).isEqualTo(TreeNode.ofWithNull(40, 20, 60, 10, 30, 50, 70, null, null, 25));
        assertThat(insertIntoBST(TreeNode.ofWithNull(4, 2, 7, 1, 3, null, null, null, null, null, null), 5)).isEqualTo(TreeNode.ofWithNull(4, 2, 7, 1, 3, 5));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST((root.right), val);
        } else {
            root.left = insertIntoBST((root.left), val);
        }
        return root;
    }
}
