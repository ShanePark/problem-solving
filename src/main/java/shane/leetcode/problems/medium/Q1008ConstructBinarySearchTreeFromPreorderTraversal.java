package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

public class Q1008ConstructBinarySearchTreeFromPreorderTraversal {

    @Test
    public void test() {
        TreeNode preorder = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        preorder.printTree();

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            add(root, preorder[i]);
        }
        return root;
    }

    private void add(TreeNode node, int i) {
        if (node.val < i) {
            if (node.right == null) {
                node.right = new TreeNode(i);
            } else {
                add(node.right, i);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(i);
            } else {
                add(node.left, i);
            }
        }
    }
}
