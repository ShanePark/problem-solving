package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 50 MB Beats 41.59%
 */
public class Q222CountCompleteTreeNodes {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        assertThat(countNodes(root)).isEqualTo(6);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        assertThat(countNodes(root)).isEqualTo(1);
    }

    @Test
    public void test3() {
        assertThat(countNodes(null)).isEqualTo(0);
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
