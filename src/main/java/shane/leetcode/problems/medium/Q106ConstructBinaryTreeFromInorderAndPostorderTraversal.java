package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 14 ms Beats 5.43%
 * Memory 88.2 MB Beats 5.31%
 */
public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    @Test
    public void test() {
        assertThat(buildTree(new int[]{2, 1}, new int[]{2, 1})).isEqualTo(TreeNode.of(1, 2));
        assertThat(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}))
                .isEqualTo(TreeNode.of(3, 9, 20, null, null, 15, 7));
        assertThat(buildTree(new int[]{-1}, new int[]{-1}))
                .isEqualTo(TreeNode.of(-1));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0)
            return null;
        if (length == 1)
            return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[length - 1]);
        int index = 0;
        while (inorder[index] != root.val) {
            index++;
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, length), Arrays.copyOfRange(postorder, index, length - 1));
        return root;
    }

}
