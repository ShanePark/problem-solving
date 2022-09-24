package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 85.41% of Java online submissions for Path Sum II.
 * Memory Usage: 45 MB, less than 31.74% of Java online submissions for Path Sum II.
 */
public class Q113PathSumII {

    @Test
    public void test() {
        TreeNode root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1);
        assertThat(pathSum(root, 22)).containsExactlyInAnyOrder(
                List.of(5, 4, 11, 2),
                List.of(5, 8, 4, 5)
        );
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.of(1, 2, 3);
        assertThat(pathSum(root, 5)).isEmpty();
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.of(1, 2);
        assertThat(pathSum(root, 0)).isEmpty();
        assertThat(pathSum(null, 1)).isEmpty();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return Collections.EMPTY_LIST;
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, targetSum, answer, new ArrayList<>());
        return answer;
    }

    private void dfs(TreeNode node, int targetSum, List<List<Integer>> answer, List<Integer> current) {
        int value = node.val;
        if (node.left == null && node.right == null && targetSum == value) {
            List<Integer> list = new ArrayList<>(current);
            list.add(value);
            answer.add(list);
            return;
        }

        if (node.left != null) {
            current.add(value);
            dfs(node.left, targetSum - value, answer, current);
            current.remove(current.size() - 1);
        }
        if (node.right != null) {
            current.add(value);
            dfs(node.right, targetSum - value, answer, current);
            current.remove(current.size() - 1);
        }
    }

}
