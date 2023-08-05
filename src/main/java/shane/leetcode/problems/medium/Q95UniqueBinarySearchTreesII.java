package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q95UniqueBinarySearchTreesII {

    @Test
    public void test() {
        assertThat(generateTrees(3)).containsExactlyInAnyOrder(TreeNode.of(1, null, 2, null, 3), TreeNode.of(1, null, 3, 2), TreeNode.of(2, 1, 3), TreeNode.of(3, 1, null, null, 2), TreeNode.of(3, 2, null, 1));
        assertThat(generateTrees(1)).containsExactlyInAnyOrder(TreeNode.of(1));
    }

    public List<TreeNode> generateTrees(int n) {
        return makeTrees(1, n);
    }

    public List<TreeNode> makeTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> smaller = makeTrees(start, i - 1);
            List<TreeNode> bigger = makeTrees(i + 1, end);

            for (TreeNode left : smaller) {
                for (TreeNode right : bigger) {
                    result.add(new TreeNode(i, left, right));
                }
            }
        }

        if (result.isEmpty())
            result.add(null);
        return result;
    }

}
