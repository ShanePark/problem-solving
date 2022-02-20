package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1302DeepestLeavesSum {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        Assertions.assertThat(deepestLeavesSum(root)).isEqualTo(15);
    }

    int maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        travel(root, map, 0);
        List<Integer> list = map.get(maxDepth);
        return list.stream().mapToInt(Integer::intValue).sum();

    }

    private void travel(TreeNode node, Map<Integer, List<Integer>> map, int depth) {
        if (node.left == null && node.right == null) {
            if (depth >= maxDepth) {
                maxDepth = Math.max(maxDepth, depth);
                List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
                list.add(node.val);
                map.put(depth, list);
            }
            return;
        }

        if (node.left != null)
            travel(node.left, map, depth + 1);
        if (node.right != null)
            travel(node.right, map, depth + 1);
    }

}
