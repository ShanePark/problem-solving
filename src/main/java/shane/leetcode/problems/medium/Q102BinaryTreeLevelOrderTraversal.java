package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q102BinaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        assertThat(levelOrder(TreeNode.ofWithNull(3, 9, 20, null, null, 15, 7))).isEqualTo(STool.convertToIntList("[[3],[9,20],[15,7]]"));
        assertThat(levelOrder(TreeNode.ofWithNull(1))).isEqualTo(STool.convertToIntList("[[1]]"));
        assertThat(levelOrder(null)).isEqualTo(STool.convertToIntList("[]"));
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
