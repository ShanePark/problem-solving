package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 89.56% of Java online submissions for Construct String from Binary Tree.
 * Memory Usage: 44.9 MB, less than 74.76% of Java online submissions for Construct String from Binary Tree.
 */
public class Q606ConstructStringFromBinaryTree {

    @Test
    public void test() {
        assertThat(tree2str(TreeNode.ofWithNull(1, 2, 3, 4))).isEqualTo("1(2(4))(3)");
        assertThat(tree2str(TreeNode.ofWithNull(1, 2, 3, null, 4))).isEqualTo("1(2()(4))(3)");
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append("(");
            dfs(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            sb.append("(");
            dfs(root.right, sb);
            sb.append(")");
        }
    }


}
