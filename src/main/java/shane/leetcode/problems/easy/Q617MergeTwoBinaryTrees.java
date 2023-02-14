package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q617MergeTwoBinaryTrees {

    @Test
    public void test() {
        TreeNode root1 = TreeNode.ofWithNull(new Integer[]{1, 3, 2, 5});
        TreeNode root2 = TreeNode.ofWithNull(new Integer[]{2, 1, 3, null, 4, null, 7});
        assertThat(mergeTrees(root1, root2)).isEqualTo(TreeNode.ofWithNull(3, 4, 5, 5, 4, null, 7));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode node = new TreeNode();
        node.val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        node.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return node;
    }

}
