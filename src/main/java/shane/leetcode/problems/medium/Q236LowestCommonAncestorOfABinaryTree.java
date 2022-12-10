package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 13 ms, faster than 28.61% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 * Memory Usage: 50.6 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 */
public class Q236LowestCommonAncestorOfABinaryTree {

    @Test
    public void test() {
        TreeNode head = TreeNode.ofWithNull(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        assertThat(lowestCommonAncestor(head, head.left, head.right)).isEqualTo(head);
    }

    @Test
    public void test2() {
        TreeNode head = TreeNode.ofWithNull(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        assertThat(lowestCommonAncestor(head, head.left, head.left.right.right)).isEqualTo(head.left);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        traverse(root, null, depthMap, parentMap, 0);
        int pDepth = depthMap.get(p);
        int qDepth = depthMap.get(q);
        if (pDepth > qDepth) {
            TreeNode temp = p;
            p = q;
            q = temp;
            int tmp = pDepth;
            pDepth = qDepth;
            qDepth = tmp;
        } else if (pDepth == qDepth) {
            p = parentMap.get(p);
            pDepth--;
        }

        TreeNode qParent = parentMap.get(q);
        while (p != qParent) {
            q = qParent;
            qParent = parentMap.get(q);
            qDepth--;
            if (pDepth == qDepth) {
                p = parentMap.get(p);
                pDepth--;
            }
        }
        return p;
    }

    private void traverse(TreeNode node, TreeNode parent, Map<TreeNode, Integer> depthMap, Map<TreeNode, TreeNode> parentMap, int depth) {
        if (node == null)
            return;
        depthMap.put(node, depth);
        parentMap.put(node, parent);
        traverse(node.left, node, depthMap, parentMap, depth + 1);
        traverse(node.right, node, depthMap, parentMap, depth + 1);
    }

}
