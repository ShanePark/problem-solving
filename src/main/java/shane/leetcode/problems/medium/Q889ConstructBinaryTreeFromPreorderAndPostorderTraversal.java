package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 4 ms, faster than 13.85% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
 * Memory Usage: 44.4 MB, less than 22.33% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
 */
public class Q889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    @Test
    public void test() {
        TreeNode answer = constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        answer.printTree();
        assertThat(answer).isEqualTo(TreeNode.ofWithNull(1, 2, 3, 4, 5, 6, 7));

        assertThat(constructFromPrePost(new int[]{1}, new int[]{1})).isEqualTo(TreeNode.ofWithNull(1));
    }

    @Test
    public void test2() {
        TreeNode answer = constructFromPrePost(new int[]{2, 1}, new int[]{1, 2});
        answer.printTree();
        assertThat(answer).isEqualTo(TreeNode.ofWithNull(2, 1));
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[0]);
        final int LENGTH = postorder.length;
        if (LENGTH > 1) {
            int left = preorder[1];
            int postIndexOfLeft = -1;
            for (int i = 0; i < LENGTH; i++) {
                if (postorder[i] == left) {
                    postIndexOfLeft = i;
                }
            }
            node.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, postIndexOfLeft + 2), Arrays.copyOfRange(postorder, 0, postIndexOfLeft + 1));
            if (postIndexOfLeft + 1 < LENGTH - 1) {
                node.right = constructFromPrePost(Arrays.copyOfRange(preorder, postIndexOfLeft + 2, LENGTH), Arrays.copyOfRange(postorder, postIndexOfLeft + 1, LENGTH - 1));
            }
        }
        return node;
    }

}
