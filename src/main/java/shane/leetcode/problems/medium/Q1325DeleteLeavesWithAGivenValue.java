package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1325DeleteLeavesWithAGivenValue {

    @Test
    public void test() {
        TreeNode actual = removeLeafNodes(TreeNode.of(1, 2, 3, 2, null, 2, 4), 2);
        assertThat(actual).isEqualTo(TreeNode.of(1, null, 3, null, null, null, 4));
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
