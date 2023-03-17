package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal2 {

    @Test
    public void test() {
        assertThat(buildTree(new int[]{1, 2, 3, 4}, new int[]{3, 2, 4, 1})).isEqualTo(TreeNode.of(1, null, 4, 2, null, null, 3));
        assertThat(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}))
                .isEqualTo(TreeNode.of(3, 9, 20, null, null, 15, 7));
        assertThat(buildTree(new int[]{2, 1}, new int[]{2, 1})).isEqualTo(TreeNode.of(1, 2));
        assertThat(buildTree(new int[]{-1}, new int[]{-1})).isEqualTo(TreeNode.of(-1));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        return buildTree(inorder, 0, length, postorder, 0, length);
    }

    public TreeNode buildTree(int[] inorder, int from1, int to1, int[] postorder, int from2, int to2) {
        if (from1 == to1) return null;
        if (from1 + 1 == to1) return new TreeNode(inorder[from1]);

        TreeNode node = new TreeNode(postorder[to2 - 1]);
        int index = from1;
        while (inorder[index] != node.val) {
            index++;
        }
        node.left = buildTree(inorder, from1, index, postorder, from2, from2 + index - from1);
        node.right = buildTree(inorder, index + 1, to1, postorder, from2 + index - from1, to2 - 1);
        return node;
    }

}
