package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 88.59% of Java online submissions for Add One Row to Tree.
 * Memory Usage: 45.5 MB, less than 46.28% of Java online submissions for Add One Row to Tree.
 */
public class Q623AddOneRowToTree {

    @Test
    public void test() {
        assertThat(addOneRow(TreeNode.of(1, 2, 3, 4), 5, 4)).isEqualTo(TreeNode.of(1, 2, 3, 4, null, null, null, 5, 5));
        assertThat(addOneRow(TreeNode.of(4, 2, null, 3, 1), 1, 3)).isEqualTo(TreeNode.of(4, 2, null, 1, 1, null, null, 3, null, null, 1));
        assertThat(addOneRow(TreeNode.of(1, 2, 3), 1, 1)).isEqualTo(TreeNode.of(1, 1, null, 2, 3));
        assertThat(addOneRow(TreeNode.of(4, 2, 6, 3, 1, 5), 1, 2)).isEqualTo(TreeNode.of(4, 1, 1, 2, null, null, 6, 3, 1, null, null, null, null, 5));
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRow(root, val, depth, true);
    }

    private TreeNode addOneRow(TreeNode root, int val, int depth, boolean isLeft) {
        if (root == null) {
            return depth == 1 ? new TreeNode(val) : null;
        }
        if (depth == 1) {
            TreeNode origin = new TreeNode(root.val);
            origin.left = root.left;
            origin.right = root.right;
            root.val = val;
            if (isLeft) {
                root.left = origin;
                root.right = null;
            } else {
                root.right = origin;
                root.left = null;
            }
            return root;
        }
        root.left = addOneRow(root.left, val, depth - 1, true);
        root.right = addOneRow(root.right, val, depth - 1, false);
        return root;
    }

}
