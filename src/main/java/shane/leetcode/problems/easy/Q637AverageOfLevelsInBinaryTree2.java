package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 76.99% of Java online submissions for Average of Levels in Binary Tree.
 * Memory Usage: 43.6 MB, less than 96.90% of Java online submissions for Average of Levels in Binary Tree.
 */
public class Q637AverageOfLevelsInBinaryTree2 {

    @Test
    public void test() {
        assertThat(averageOfLevels(TreeNode.of(2147483647, 2147483647, 2147483647))).containsExactly(2147483647.00000, 2147483647.00000);
        assertThat(averageOfLevels(TreeNode.of(3, 9, 20, null, null, 15, 7))).containsExactly(3.00000, 14.50000, 11.00000);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Depth> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.stream().map(d -> d.avg())
                .collect(Collectors.toList());
    }

    private void dfs(TreeNode root, int depth, List<Depth> depths) {
        if (root == null)
            return;
        if (depths.size() == depth) {
            depths.add(new Depth());
        }
        Depth d = depths.get(depth);
        d.add(root.val);
        dfs(root.left, depth + 1, depths);
        dfs(root.right, depth + 1, depths);
    }

    class Depth {
        int cnt;
        long sum;

        public void add(int num) {
            cnt++;
            sum += num;
        }

        public double avg() {
            return (double) sum / cnt;
        }
    }

}
