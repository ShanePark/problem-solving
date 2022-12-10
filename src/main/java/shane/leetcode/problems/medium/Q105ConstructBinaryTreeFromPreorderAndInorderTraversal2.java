package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 4 ms, faster than 64.48% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 44.7 MB, less than 28.97% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 */
@SuppressWarnings("ALL")
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal2 {

    @Test
    public void test() {
        assertThat(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})).isEqualTo(TreeNode.ofWithNull(3, 9, 20, null, null, 15, 7));
        assertThat(buildTree(new int[]{-1}, new int[]{-1})).isEqualTo(TreeNode.ofWithNull(-1));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return node(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    private TreeNode node(int i, int from, int end, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (i == preorder.length || from > end) {
            return null;
        }
        int n = preorder[i];
        TreeNode root = new TreeNode(n);
        int inorderIndex = map.get(n);
        root.left = node(i + 1, from, inorderIndex - 1, preorder, inorder, map);
        root.right = node(i + (inorderIndex - from + 1), inorderIndex + 1, end, preorder, inorder, map);
        return root;
    }
}
