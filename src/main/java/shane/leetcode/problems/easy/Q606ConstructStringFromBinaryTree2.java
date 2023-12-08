package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 100.00%of users with Java
 * Memory Details 43.32MB Beats 76.64%of users with Java
 */
public class Q606ConstructStringFromBinaryTree2 {

    @Test
    public void test() {
        assertThat(tree2str(TreeNode.of(1, 2, 3, 4))).isEqualTo("1(2(4))(3)");
        assertThat(tree2str(TreeNode.of(1, 2, 3, null, 4))).isEqualTo("1(2()(4))(3)");
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val);
        if (node.left != null || node.right != null) {
            sb.append("(");
            traverse(node.left, sb);
            sb.append(")");
        }
        if (node.right != null) {
            sb.append("(");
            traverse(node.right, sb);
            sb.append(")");
        }
    }


}
