package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1261FindElementsInAContaminatedBinaryTree {
    @Test
    public void test() {
        TreeNode tree = TreeNode.of(-1, null, -1);
        FindElements findElements = new FindElements(tree);
        assertThat(findElements.find(1)).isEqualTo(false);
        assertThat(findElements.find(2)).isEqualTo(true);
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNode.of(-1, null, -1, null, null, -1, null, null, null, null, null, -1);
        FindElements findElements = new FindElements(tree);
        assertThat(findElements.find(2)).isEqualTo(true);
        assertThat(findElements.find(3)).isEqualTo(false);
        assertThat(findElements.find(4)).isEqualTo(false);
        assertThat(findElements.find(5)).isEqualTo(true);
    }
}

class FindElements {

    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        root.val = 0;
//        fix(root);
    }

    private void fix(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
        }
    }

    public boolean find(int target) {
        return find(root, target);
    }

    private boolean find(TreeNode root, int target) {
        TreeNode cur = root;
        Stack<Integer> stack = new Stack<>();
        while (target > 0) {
            stack.push((target - 1) % 2);
            target = (target - 1) / 2;
        }

        while (!stack.isEmpty() && cur != null) {
            Integer pop = stack.pop();
            if (pop == 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }


        return stack.isEmpty() && cur != null;
    }

}
