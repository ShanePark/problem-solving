package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6ms
 * Beats5.13%
 */
public class Q1123LowestCommonAncestorOfDeepestLeaves3 {

    @Test
    public void test() {
        assertThat(lcaDeepestLeaves(TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))).isEqualTo(TreeNode.of(2, 7, 4));
        assertThat(lcaDeepestLeaves(TreeNode.of(1))).isEqualTo(TreeNode.of(1));
        assertThat(lcaDeepestLeaves(TreeNode.of(0, 1, 3, null, 2))).isEqualTo(TreeNode.of(2));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        LeavesFinder leavesFinder = new LeavesFinder();
        dfs(root, null, leavesFinder, 0);
        return leavesFinder.lacDeepest();
    }

    private void dfs(TreeNode node, TreeNode parent, LeavesFinder leavesFinder, int depth) {
        if (node == null)
            return;
        leavesFinder.maxDepthCheck(depth);
        leavesFinder.check(node, parent, depth);
        dfs(node.left, node, leavesFinder, depth + 1);
        dfs(node.right, node, leavesFinder, depth + 1);
    }

    static class LeavesFinder {
        private int maxDepth = 0;
        private final Set<TreeNode> leaves = new HashSet<>();
        private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        public void maxDepthCheck(int depth) {
            if (this.maxDepth < depth) {
                this.leaves.clear();
                this.maxDepth = depth;
            }
        }

        public void check(TreeNode node, TreeNode parent, int depth) {
            parentMap.put(node, parent);
            if (depth < this.maxDepth) {
                return;
            }
            this.leaves.add(node);
        }

        public TreeNode lacDeepest() {
            while (leaves.size() > 1) {
                Set<TreeNode> parents = leaves.stream().map(parentMap::get).collect(Collectors.toSet());
                this.leaves.clear();
                this.leaves.addAll(parents);
            }
            return leaves.stream().findAny().get();
        }
    }

}
