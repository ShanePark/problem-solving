package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 14 ms, faster than 6.18% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 * Memory Usage: 51.5 MB, less than 6.63% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 */
public class Q235LowestCommonAncestorOfABinarySearchTree {

    @Test
    public void test() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left, node.right)).isEqualTo(node);
    }

    @Test
    public void test2() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left, node.left.right)).isEqualTo(node.left);
    }

    @Test
    public void test3() {
        TreeNode node = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertThat(lowestCommonAncestor(node, node.left.right.right, node.right.left)).isEqualTo(node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(root, parentMap);
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(q);
        while (true) {
            TreeNode pParent = parentMap.get(p);
            TreeNode qParent = parentMap.get(q);
            if (pParent != null && !set.add(pParent)) {
                return pParent;
            }
            if (qParent != null && !set.add(qParent)) {
                return qParent;
            }
            p = pParent;
            q = qParent;
        }
    }

    private void findParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            findParent(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            findParent(root.right, parentMap);
        }
    }
}
