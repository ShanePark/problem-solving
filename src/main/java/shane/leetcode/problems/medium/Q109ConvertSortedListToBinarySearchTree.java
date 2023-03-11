package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 40.56%
 * Memory 44.2 MB Beats 13.81%
 */
public class Q109ConvertSortedListToBinarySearchTree {

    @Test
    void test() {
        TreeNode tree = sortedListToBST(ListNode.of(-10, -3, 0, 5, 9));
        assertBalancedBinary(tree);
        tree.printTree();
    }

    @Test
    void test2() {
        assertThat(sortedListToBST(null)).isNull();
    }

    private void assertBalancedBinary(TreeNode tree) {
        if (tree.left != null) {
            assertThat(tree.val).isGreaterThanOrEqualTo(tree.left.val);
            assertBalancedBinary(tree.left);
        }
        if (tree.right != null) {
            assertThat(tree.val).isLessThanOrEqualTo(tree.right.val);
            assertBalancedBinary(tree.right);
        }
        if (tree.left != null && tree.right != null) {
            assertThat(tree.left.getMaxDepth()).isEqualTo(tree.right.getMaxDepth());
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return binaryTree(list, 0, list.size() - 1);
    }

    private TreeNode binaryTree(List<Integer> list, int left, int right) {
        if (left == right)
            return new TreeNode(list.get(left));
        int mid = (left + right) / 2;
        TreeNode tree = new TreeNode(list.get(mid));
        if (left <= mid - 1) {
            tree.left = binaryTree(list, left, mid - 1);
        }
        if (mid + 1 <= right) {
            tree.right = binaryTree(list, mid + 1, right);
        }
        return tree;
    }

}
