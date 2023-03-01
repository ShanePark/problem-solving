package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1315SumOfNodesWithEvenValuedGrandparent {

    @Test
    void test() {
        TreeNode tree = TreeNode.of(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        Assertions.assertThat(sumEvenGrandparent(tree)).isEqualTo(18);
    }

    public int sumEvenGrandparent(TreeNode root) {
        return traverse(root, false, false);
    }

    private int traverse(TreeNode root, boolean parentIsEven, boolean grandParentIsEven) {
        int sum = 0;
        if (grandParentIsEven) {
            sum += root.val;
        }

        if (root.left != null) {
            sum += traverse(root.left, root.val % 2 == 0, parentIsEven);
        }
        if (root.right != null) {
            sum += traverse(root.right, root.val % 2 == 0, parentIsEven);

        }
        return sum;

    }

}
