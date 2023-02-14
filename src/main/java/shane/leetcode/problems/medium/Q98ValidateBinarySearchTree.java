package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 23.55% of Java online submissions for Validate Binary Search Tree.
 * Memory Usage: 45.5 MB, less than 5.89% of Java online submissions for Validate Binary Search Tree.
 */
public class Q98ValidateBinarySearchTree {

    @Test
    public void test() {
        assertThat(isValidBST(TreeNode.ofWithNull(3, 1, 5, 0, 2, 4, 6, null, null, null, 3))).isFalse();
        assertThat(isValidBST(TreeNode.ofWithNull(2, 1, 3))).isTrue();
        assertThat(isValidBST(TreeNode.ofWithNull(2, 2, 2))).isFalse();
        assertThat(isValidBST(TreeNode.ofWithNull(5, 1, 4, null, null, 3, 6))).isFalse();
    }

    public boolean isValidBST(TreeNode root) {
        Check check = check(root);
        return check.valid;
    }

    private Check check(TreeNode root) {
        if (root == null) {
            return new Check(true);
        }
        Check left = check(root.left);
        Check right = check(root.right);
        if (!left.valid
                || !right.valid
                || (left.max != null && (root.val <= left.max))
                || (right.min != null && right.min <= root.val)) {
            return new Check(false);
        }
        Check check = new Check(left.min == null ? root.val : left.min, right.max == null ? root.val : right.max);
        return check;
    }

    class Check {
        Integer min;
        Integer max;
        boolean valid = true;

        public Check(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        public Check(boolean valid) {
            this.valid = valid;
        }
    }

}
