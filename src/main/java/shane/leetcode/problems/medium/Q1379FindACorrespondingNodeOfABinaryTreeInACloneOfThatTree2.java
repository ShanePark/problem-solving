package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree2 {

    @Test
    public void test() {
        TreeNode original = TreeNode.of(7, 4, 3, null, null, 6, 19);
        TreeNode cloned = TreeNode.of(7, 4, 3, null, null, 6, 19);
        TreeNode target = original.right;
        assertThat(getTargetCopy(original, cloned, target)).isEqualTo(cloned.right);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target)
            return cloned;

        TreeNode result = null;
        if (original.left != null)
            result = getTargetCopy(original.left, cloned.left, target);
        if (result == null && original.right != null)
            result = getTargetCopy(original.right, cloned.right, target);

        return result;
    }
}
