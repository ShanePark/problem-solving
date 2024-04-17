package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 27.25% of users with Java
 */
public class Q988SmallestStringStartingFromLeaf {

    @Test
    public void test() {
        assertThat(smallestFromLeaf(TreeNode.of(0, 1, 2, 3, 4, 3, 4))).isEqualTo("dba");
        assertThat(smallestFromLeaf(TreeNode.of(25, 1, 3, 1, 3, 0, 2))).isEqualTo("adz");
        assertThat(smallestFromLeaf(TreeNode.of(2, 2, 1, null, 1, 0, null, 0))).isEqualTo("abc");
    }

    String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return smallest;
    }

    private void traverse(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        char curChar = (char) ('a' + node.val);
        if (node.left != null || node.right != null) {
            sb.insert(0, curChar);
            traverse(node.left, sb);
            traverse(node.right, sb);
            sb.deleteCharAt(0);
            return;
        }

        String str = curChar + sb.toString();
        if (isSmaller(str, smallest)) {
            smallest = str;
        }
    }

    private boolean isSmaller(String str, String smallest) {
        if (smallest == null)
            return true;
        int length = Math.min(str.length(), smallest.length());
        for (int i = 0; i < length; i++) {
            char c1 = str.charAt(i);
            char c2 = smallest.charAt(i);
            if (c1 == c2)
                continue;
            return c1 < c2;
        }
        return str.length() < smallest.length();
    }

}
