package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q538ConvertBSTToGreaterTree {

    @Test
    public void test() {
        sum = 0;
        TreeNode tree = TreeNode.ofWithNull(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        TreeNode after = convertBST(tree);
        after.printTree();
        assertThat(after.val).isEqualTo(30);
        assertThat(after.left.val).isEqualTo(36);
        assertThat(after.right.val).isEqualTo(21);
    }

    @Test
    public void test2() {
        sum = 0;
        TreeNode tree = TreeNode.ofWithNull(new Integer[]{0, null, 1});
        TreeNode after = convertBST(tree);
        assertThat(after.val).isEqualTo(1);
        assertThat(after.left).isEqualTo(null);
        assertThat(after.right.val).isEqualTo(1);
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

}
