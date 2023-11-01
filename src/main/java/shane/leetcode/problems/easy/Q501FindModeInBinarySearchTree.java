package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 7ms Beats 31.79%of users with Java
 * Memory Details 44.90MB Beats 18.89%of users with Java
 */
public class Q501FindModeInBinarySearchTree {

    @Test
    public void test() {
        assertThat(findMode(TreeNode.of(1, null, 2))).containsExactly(1, 2);
        assertThat(findMode(TreeNode.of(1, null, 2, 2))).containsExactly(2);
        assertThat(findMode(TreeNode.of(0))).containsExactly(0);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        dfs(root, cntMap);

        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
            if (e.getValue() < max) {
                continue;
            }
            if (e.getValue() > max) {
                set.clear();
                max = e.getValue();
            }
            set.add(e.getKey());
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void dfs(TreeNode node, Map<Integer, Integer> cntMap) {
        if (node == null)
            return;
        cntMap.merge(node.val, 1, Integer::sum);
        dfs(node.left, cntMap);
        dfs(node.right, cntMap);
    }

}
