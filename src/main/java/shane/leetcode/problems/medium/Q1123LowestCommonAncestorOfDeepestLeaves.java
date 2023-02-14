package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 8 ms, faster than 5.28% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
 * Memory Usage: 44.8 MB, less than 39.50% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
 */
public class Q1123LowestCommonAncestorOfDeepestLeaves {

    @Test
    public void test() {
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))).isEqualTo(TreeNode.ofWithNull(2, 7, 4));
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(1))).isEqualTo(TreeNode.ofWithNull(1));
        assertThat(lcaDeepestLeaves(TreeNode.ofWithNull(0, 1, 3, null, 2))).isEqualTo(TreeNode.ofWithNull(2));
    }


    int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;
        Set<TreeNode> deepest = new HashSet<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, 0, deepest, parentMap);

        while (deepest.size() > 1) {
            Set<TreeNode> parents = new HashSet<>();
            for (TreeNode node : deepest) {
                parents.add(parentMap.get(node));
            }
            deepest = parents;
        }

        return deepest.stream().findAny().get();
    }

    private void dfs(TreeNode root, int depth, Set<TreeNode> deepest, Map<TreeNode, TreeNode> parentMap) {
        if (maxDepth == depth) {
            deepest.add(root);
        } else if (maxDepth < depth) {
            maxDepth = depth;
            deepest.clear();
            deepest.add(root);
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left, depth + 1, deepest, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right, depth + 1, deepest, parentMap);
        }
    }
}
