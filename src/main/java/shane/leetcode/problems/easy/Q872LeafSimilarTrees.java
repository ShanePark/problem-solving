package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.2 MB Beats 88.24%
 */
public class Q872LeafSimilarTrees {

    @Test
    public void test() {
        assertThat(leafSimilar(
                TreeNode.of(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
                , TreeNode.of(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)))
                .isTrue();
        assertThat(leafSimilar(
                TreeNode.of(1, 2, 3)
                , TreeNode.of(1, 3, 2)))
                .isFalse();
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return findLeaf(root1, new StringBuilder()).toString().equals(findLeaf(root2, new StringBuilder()).toString());
    }

    private StringBuilder findLeaf(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val)
                    .append(" ");
        }
        if (node.left != null) {
            findLeaf(node.left, sb);
        }
        if (node.right != null) {
            findLeaf(node.right, sb);
        }
        return sb;
    }

}
