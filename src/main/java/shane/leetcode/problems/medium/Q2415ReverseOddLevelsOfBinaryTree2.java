package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12ms Beats18.08%
 */
public class Q2415ReverseOddLevelsOfBinaryTree2 {

    @Test
    public void test() {
        assertThat(reverseOddLevels(TreeNode.of(2, 3, 5, 8, 13, 21, 34))).isEqualTo(TreeNode.of(2, 5, 3, 8, 13, 21, 34));
        assertThat(reverseOddLevels(TreeNode.of(7, 13, 11))).isEqualTo(TreeNode.of(7, 11, 13));
        assertThat(reverseOddLevels(TreeNode.of(0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2))).isEqualTo(TreeNode.of(0, 2, 1, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1));
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer, List<TreeNode>> depths = new HashMap<>();
        preOrder(root, depths, 0);
        for (int depth = 1; depth < depths.size(); depth += 2) {
            List<TreeNode> list = depths.get(depth);
            int SIZE = list.size();
            for (int i = 0; i < SIZE / 2; i++) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(SIZE - 1 - i);
                int tmp = left.val;
                left.val = right.val;
                right.val = tmp;
            }
        }
        return root;
    }

    private void preOrder(TreeNode node, Map<Integer, List<TreeNode>> depths, int depth) {
        if (node == null)
            return;
        List<TreeNode> list = depths.computeIfAbsent(depth, i -> new ArrayList<>());
        list.add(node);
        preOrder(node.left, depths, depth + 1);
        preOrder(node.right, depths, depth + 1);
    }

}
