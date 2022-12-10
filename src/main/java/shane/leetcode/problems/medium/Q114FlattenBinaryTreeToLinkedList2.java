package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q114FlattenBinaryTreeToLinkedList2 {

    @Test
    public void test() {
        TreeNode root = TreeNode.ofWithNull(1, 2, 5, 3, 4, null, 6);
        flatten(root);
        int i = 1;
        while (root != null) {
            assertThat(root.val).isEqualTo(i++);
            root = root.right;
        }
        assertThat(i).isEqualTo(7);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.ofWithNull(0);
        flatten(root);
        assertThat(root.val).isEqualTo(0);
    }

    @Test
    public void test3() {
        flatten(null);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);

        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;
        root.right = left;

        TreeNode tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = right;
        flatten(right);
    }

}
