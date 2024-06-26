package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2msBeats96.27%
 */
public class Q1382BalanceABinarySearchTree2 {

    @Test
    public void test() {
        Assertions.assertThat(balanceBST(TreeNode.of(1, null, 2, null, 3, null, 4, null, null))).isEqualTo(TreeNode.of(2, 1, 3, null, null, null, 4));
        Assertions.assertThat(balanceBST(TreeNode.of(2, 1, 3))).isEqualTo(TreeNode.of(2, 1, 3));
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return makeTreeNode(list, 0, list.size() - 1);
    }

    private TreeNode makeTreeNode(List<Integer> list, int i, int j) {
        if (j < i) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if (i == j) {
            return node;
        }
        node.left = makeTreeNode(list, i, mid - 1);
        node.right = makeTreeNode(list, mid + 1, j);
        return node;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
