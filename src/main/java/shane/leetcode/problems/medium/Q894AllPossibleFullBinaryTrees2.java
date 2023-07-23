package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 16 / 20 testcases passed
 */
public class Q894AllPossibleFullBinaryTrees2 {

    @Test
    public void test() {
        assertThat(allPossibleFBT(7)).hasSize(5);
        assertThat(allPossibleFBT(3)).hasSize(1);
    }

    @Test
    void tle() {
        assertThat(allPossibleFBT(19)).hasSize(4862);
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1)
            return List.of(new TreeNode());

        List<TreeNode> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode();
                    node.left = left;
                    node.right = right;
                    answer.add(node);
                }
            }
        }

        return answer;
    }


}
