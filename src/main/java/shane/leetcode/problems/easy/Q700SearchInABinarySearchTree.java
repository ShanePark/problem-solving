package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q700SearchInABinarySearchTree {

    @Test
    public void test() {
        TreeNode tree = searchBST(TreeNode.ofWithNull(new Integer[]{4, 2, 7, 1, 3}), 2);
        assertThat(tree.val).isEqualTo(2);
        assertThat(tree.left.val).isEqualTo(1);
        assertThat(tree.right.val).isEqualTo(3);
        TreeNode tree2 = searchBST(TreeNode.ofWithNull(new Integer[]{4, 2, 7, 1, 3}), 5);
        assertThat(tree2).isNull();
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
