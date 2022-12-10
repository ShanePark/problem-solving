package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 49.41% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 41.9 MB, less than 77.51% of Java online submissions for Binary Tree Inorder Traversal.
 */
public class Q94BinaryTreeInorderTraversal2 {

    @Test
    public void test() {
        assertThat(inorderTraversal(TreeNode.ofWithNull(2, 3, null, 1))).containsExactly(1, 3, 2);
        assertThat(inorderTraversal(TreeNode.ofWithNull(1, null, 2, null, null, 3))).containsExactly(1, 3, 2);
        assertThat(inorderTraversal(null)).isEmpty();
        assertThat(inorderTraversal(TreeNode.ofWithNull(1))).containsExactly(1);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!(root == null && stack.empty())) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            answer.add(pop.val);
            root = pop.right;
        }
        return answer;
    }

}
