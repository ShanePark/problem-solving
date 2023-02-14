package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.4 MB Beats 88.15%
 */
public class Q144BinaryTreePreorderTraversal {

    @Test
    public void test() {
        assertThat(preorderTraversal(TreeNode.of(1, null, 2, 3))).containsExactly(1, 2, 3);
        assertThat(preorderTraversal(null)).isEmpty();
        assertThat(preorderTraversal(TreeNode.of(1))).containsExactly(1);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

}
