package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

public class Q1038BinarySearchTreeToGreaterSumTree2 {

    @Test
    void test() {
        TreeNode root = TreeNode.of(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        bstToGst(root).printTree();

    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return null;

        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);

        return root;

    }

}
