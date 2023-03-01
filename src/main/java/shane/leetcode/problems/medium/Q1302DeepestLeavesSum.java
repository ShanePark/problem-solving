package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> deepestList = new ArrayList<>();
        travel(root, deepestList, 0);
        return deepestList.stream().mapToInt(Integer::valueOf).sum();
    }

    private void travel(TreeNode node, List<Integer> list, int depth) {
        if (node.left == null && node.right == null) {
            if (depth < maxDepth)
                return;
            if (depth > maxDepth) {
                list.clear();
                maxDepth = depth;
            }
            list.add(node.val);
            return;
        }

        if (node.left != null)
            travel(node.left, list, depth + 1);
        if (node.right != null)
            travel(node.right, list, depth + 1);
    }

}
