package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 41.32%
 * Memory 42.3 MB Beats 45.70%
 */
public class Q662MaximumWidthOfBinaryTree3 {

    @Test
    void test() {
        assertThat(widthOfBinaryTree(TreeNode.of(1, 3, 2, 5, 3, null, 9))).isEqualTo(4);
        assertThat(widthOfBinaryTree(TreeNode.of(1, 3, 2, 5, null, null, 9, 6, null, 7))).isEqualTo(7);
        assertThat(widthOfBinaryTree(TreeNode.of(1, 3, 2, 5))).isEqualTo(2);
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0, 0);
        int max = 1;
        for (List<Integer> curDepth : list) {
            int first = curDepth.get(0);
            int last = curDepth.get(curDepth.size() - 1);
            max = Math.max(max, last - first + 1);
        }
        return max;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int depth, int index) {
        if (node == null)
            return;
        if (list.size() == depth) {
            list.add(new ArrayList<>());
        }
        List<Integer> curDepth = list.get(depth);
        curDepth.add(index);
        dfs(node.left, list, depth + 1, index * 2);
        dfs(node.right, list, depth + 1, index * 2 + 1);
    }

}
