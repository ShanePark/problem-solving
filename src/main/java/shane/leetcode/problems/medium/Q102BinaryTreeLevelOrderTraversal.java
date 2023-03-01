package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q102BinaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        assertThat(levelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7))).isEqualTo(Ps.intList("[[3],[9,20],[15,7]]"));
        assertThat(levelOrder(TreeNode.of(1))).isEqualTo(Ps.intList("[[1]]"));
        assertThat(levelOrder(null)).isEqualTo(Ps.intList("[]"));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int depth) {
        if (root == null)
            return;
        if (list.size() < depth + 1) {
            list.add(new ArrayList<>());
        }
        List<Integer> l = list.get(depth);
        l.add(root.val);
        if (root.left != null)
            dfs(root.left, list, depth + 1);
        if (root.right != null)
            dfs(root.right, list, depth + 1);
    }
}
