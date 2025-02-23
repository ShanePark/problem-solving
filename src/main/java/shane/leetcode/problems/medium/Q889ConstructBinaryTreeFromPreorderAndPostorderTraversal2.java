package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q889ConstructBinaryTreeFromPreorderAndPostorderTraversal2 {

    @Test
    public void test() {
        assertThat(constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1})).isEqualTo(TreeNode.of(1, 2, 3, 4, 5, 6, 7));
        assertThat(constructFromPrePost(new int[]{1}, new int[]{1})).isEqualTo(TreeNode.of(1));
        assertThat(constructFromPrePost(new int[]{1, 2}, new int[]{2, 1})).isEqualTo(TreeNode.of(1, 2));
        assertThat(constructFromPrePost(new int[]{3, 4, 1, 2}, new int[]{1, 4, 2, 3})).isEqualTo(TreeNode.of(3, 4, 2, 1));
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        final int LENGTH = preorder.length;
        return make(preorder, 0, LENGTH - 1, postorder, 0, LENGTH - 1);
    }

    private TreeNode make(int[] preorder, int from1, int to1, int[] postorder, int from2, int to2) {
        TreeNode node = new TreeNode(preorder[from1]);
        if (from1 == to1)
            return node;
        int leftVal = preorder[from1 + 1];
        int indexOfLeftOnPostOrder = findIndexOf(postorder, leftVal, from2);
        int leftElementsCnt = indexOfLeftOnPostOrder - from2 + 1;
        node.left = make(preorder, from1 + 1, from1 + leftElementsCnt, postorder, from2, indexOfLeftOnPostOrder);
        if (from1 + leftElementsCnt < to1) {
            node.right = make(preorder, from1 + leftElementsCnt + 1, to1, postorder, indexOfLeftOnPostOrder + 1, to2 - 1);
        }
        return node;
    }

    private int findIndexOf(int[] arr, int target, int i) {
        for (; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

}
