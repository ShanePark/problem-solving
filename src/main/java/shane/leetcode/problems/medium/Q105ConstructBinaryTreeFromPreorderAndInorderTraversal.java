package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 192 ms, faster than 5.04% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 118.1 MB, less than 5.01% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    public void test() {
        assertThat(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})).isEqualTo(TreeNode.of(3, 9, 20, null, null, 15, 7));
        assertThat(buildTree(new int[]{-1}, new int[]{-1})).isEqualTo(TreeNode.of(-1));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int number = preorder[i];
            TreeNode cur = root;
            while (true) {
                TreeNode next;
                Integer head = map.get(cur.val);
                Integer index = map.get(number);
                if (head < index) {
                    next = cur.right;
                    if (next == null) {
                        cur.right = new TreeNode(number);
                        break;
                    }
                } else {
                    next = cur.left;
                    if (next == null) {
                        cur.left = new TreeNode(number);
                        break;
                    }
                }
                cur = next;
            }
        }

        return root;
    }
}
