package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 97.13% of Java online submissions for Two Sum IV - Input is a BST.
 * Memory Usage: 42.4 MB, less than 98.84% of Java online submissions for Two Sum IV - Input is a BST.
 */
public class Q653TwoSumIVInputIsABST {

    @Test
    public void test() {
        assertThat(findTarget(TreeNode.of(5, 3, 6, 2, 4, null, 7), 9)).isTrue();
        assertThat(findTarget(TreeNode.of(5, 3, 6, 2, 4, null, 7), 28)).isFalse();
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
