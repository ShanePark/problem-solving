package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 * Memory Usage: 44.3 MB, less than 15.18% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 */
public class Q108ConvertSortedArrayToBinarySearchTree {

    @Test
    public void test() {
        assertThat(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})).isEqualTo(TreeNode.of(0, -3, 9, -10, null, 5));
        assertThat(sortedArrayToBST(new int[]{1, 3})).isEqualTo(TreeNode.of(3, 1));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
