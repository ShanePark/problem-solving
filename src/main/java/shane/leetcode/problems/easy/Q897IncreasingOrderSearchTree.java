package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q897IncreasingOrderSearchTree {

    @Test
    public void test() {
        TreeNode node = increasingBST(TreeNode.ofWithNull(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, null, null, 7, 9}));
        for (int i = 1; i < 10; i++) {
            assertThat(node.val).isEqualTo(i);
            node = node.right;
        }
    }

    @Test
    public void test2() {
        TreeNode node = increasingBST(TreeNode.ofWithNull(new Integer[]{5, 1, 7}));
        assertThat(node.val).isEqualTo(1);
        assertThat(node.right.val).isEqualTo(5);
        assertThat(node.right.right.val).isEqualTo(7);
    }

    List<Integer> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);

        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;
        for (int i = 0; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return dummy.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
