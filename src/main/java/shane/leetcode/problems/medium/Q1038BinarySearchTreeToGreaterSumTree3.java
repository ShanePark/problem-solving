package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats7.53%
 */
public class Q1038BinarySearchTreeToGreaterSumTree3 {

    @Test
    void test() {
        assertThat(bstToGst(TreeNode.of(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8))).isEqualTo(TreeNode.of(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8));
        assertThat(bstToGst(TreeNode.of(0, null, 1))).isEqualTo(TreeNode.of(1, null, 1));
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list, Comparator.reverseOrder());
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        for (Integer i : list) {
            sum += i;
            sumMap.put(i, sum);
        }
        traverse(root, sumMap);
        return root;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    private void traverse(TreeNode root, Map<Integer, Integer> sumMap) {
        if (root == null)
            return;
        root.val = sumMap.get(root.val);
        traverse(root.left, sumMap);
        traverse(root.right, sumMap);
    }

}
