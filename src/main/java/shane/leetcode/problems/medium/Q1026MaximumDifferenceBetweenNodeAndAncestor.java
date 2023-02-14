package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1026MaximumDifferenceBetweenNodeAndAncestor {

    @Test
    public void test() {
        assertThat(maxAncestorDiff(TreeNode.ofWithNull(1, null, 2, null, null, null, 0, null, null, null, null, null, null, 3))).isEqualTo(3);
        assertThat(maxAncestorDiff(TreeNode.ofWithNull(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, null, null, 13))).isEqualTo(7);
    }

    int answer;

    public int maxAncestorDiff(TreeNode root) {
        answer = 0;
        dfs(root, root.val, root.val);
        return answer;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return;
        answer = Math.max(answer, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
