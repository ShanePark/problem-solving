package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q951FlipEquivalentBinaryTrees {

    @Test
    public void test() {
        assertThat(flipEquiv(TreeNode.of(1, 2, 3, 4, 5, 6, null, null, null, 7, 8), TreeNode.of(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7))).isTrue();
        assertThat(flipEquiv(TreeNode.of(), TreeNode.of())).isTrue();
        assertThat(flipEquiv(TreeNode.of(), TreeNode.of(1))).isFalse();
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.val != root2.val)
            return false;
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

}
