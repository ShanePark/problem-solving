package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 98.83%of users with Java
 * Memory Details 44.15MB Beats 48.90%of users with Java
 */
public class Q515FindLargestValueInEachTreeRow {

    @Test
    public void test() {
        assertThat(largestValues(TreeNode.of(1, 3, 2, 5, 3, null, 9))).containsExactly(1, 3, 9);
        assertThat(largestValues(TreeNode.of(1, 2, 3))).containsExactly(1, 3);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, 0, answer);
        return answer;
    }

    private void dfs(TreeNode node, int depth, List<Integer> answer) {
        if (node == null)
            return;

        if (answer.size() == depth) {
            answer.add(node.val);
        }

        int cur = answer.get(depth);
        if (cur < node.val) {
            answer.remove(depth);
            answer.add(depth, node.val);
        }

        dfs(node.left, depth + 1, answer);
        dfs(node.right, depth + 1, answer);
    }

}
