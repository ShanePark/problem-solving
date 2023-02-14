package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 18 ms, faster than 5.70% of Java online submissions for Average of Levels in Binary Tree.
 * Memory Usage: 48.6 MB, less than 10.54% of Java online submissions for Average of Levels in Binary Tree.
 */
public class Q637AverageOfLevelsInBinaryTree {

    @Test
    public void test() {
        assertThat(averageOfLevels(TreeNode.ofWithNull(3, 9, 20, null, null, 15, 7))).containsExactly(3.00000, 14.50000, 11.00000);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.stream().map(
                l -> l.stream().mapToInt(i -> i).average().getAsDouble()
        ).collect(Collectors.toList());
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> depths) {
        if (root == null)
            return;
        if (depths.size() == depth) {
            depths.add(new ArrayList<>());
        }
        List<Integer> list = depths.get(depth);
        list.add(root.val);
        dfs(root.left, depth + 1, depths);
        dfs(root.right, depth + 1, depths);
    }
}
