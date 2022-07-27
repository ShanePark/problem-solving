package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 16.23% of Java online submissions for Flatten Binary Tree to Linked List.
 * Memory Usage: 42.5 MB, less than 60.12% of Java online submissions for Flatten Binary Tree to Linked List.
 */
public class Q114FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {
        TreeNode root = TreeNode.of(1, 2, 5, 3, 4, null, 6);
        flatten(root);
        int i = 1;
        while (root != null) {
            assertThat(root.val).isEqualTo(i++);
            root = root.right;
        }
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.of(0);
        flatten(root);
        assertThat(root.val).isEqualTo(0);
    }

    @Test
    public void test3() {
        flatten(null);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        root.left = null;
        root.val = list.get(0);
        TreeNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
