package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q669TrimABinarySearchTree {

    @Test
    public void test() {
        TreeNode before = TreeNode.ofWithNull(new Integer[]{1, 0, 2});
        TreeNode after = trimBST(before, 1, 2);
        assertThat(after.val).isEqualTo(1);
        assertThat(after.left).isNull();
        assertThat(after.right.val).isEqualTo(2);
    }

    @Test
    public void test2() {
        TreeNode before = TreeNode.ofWithNull(new Integer[]{3, 0, 4, null, 2, null, null, null, null, 1});
        TreeNode after = trimBST(before, 1, 3);
        after.printTree();
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
