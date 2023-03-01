package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40 MB Beats 62.93%
 */
public class Q100SameTree {

    @Test
    public void test() {
        assertThat(isSameTree(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3))).isTrue();
        assertThat(isSameTree(TreeNode.of(1, 2, 3), TreeNode.of(1, 2))).isFalse();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
