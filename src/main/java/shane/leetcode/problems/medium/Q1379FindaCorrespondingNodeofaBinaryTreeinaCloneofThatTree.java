package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1379FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {

    @Test
    void test() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);

        TreeNode clone = new TreeNode(7);
        clone.left = new TreeNode(4);
        clone.right = new TreeNode(3);
        clone.right.left = new TreeNode(6);
        clone.right.right = new TreeNode(19);

        TreeNode result = getTargetCopy(root, clone, root.right);
        Assertions.assertThat(result.val).isEqualTo(root.right.val);
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(8);

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);

        root.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode clone = new TreeNode(1);

        clone.left = new TreeNode(2);
        clone.left.left = new TreeNode(4);
        clone.left.left.left = new TreeNode(8);
        clone.left.left.right = new TreeNode(8);
        clone.left.right = new TreeNode(5);
        clone.left.right.left = new TreeNode(10);
        clone.right = new TreeNode(3);
        clone.right.left = new TreeNode(6);
        clone.right.right = new TreeNode(7);

        TreeNode result = getTargetCopy(root, clone, root.right.right);
        Assertions.assertThat(result.val).isEqualTo(root.right.right.val);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        } else if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        return left == null ? getTargetCopy(original.right, cloned.right, target) : left;
    }

}
