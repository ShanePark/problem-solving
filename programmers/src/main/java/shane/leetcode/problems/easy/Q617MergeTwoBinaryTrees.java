package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q617MergeTwoBinaryTrees {

    @Test
    public void test() {
        TreeNode root1 = TreeNode.of(new Integer[]{1, 3, 2, 5});
        TreeNode root2 = TreeNode.of(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode merge = mergeTrees(root1, root2);
        assertThat(merge.val).isEqualTo(3);
        assertThat(merge.left.val).isEqualTo(4);
        assertThat(merge.left.left.val).isEqualTo(5);
        assertThat(merge.left.right.val).isEqualTo(4);
        assertThat(merge.right.val).isEqualTo(5);
        assertThat(merge.right.left).isNull();
        assertThat(merge.right.right.val).isEqualTo(7);
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
