package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats97.28%
 */
public class Q1110DeleteNodesAndReturnForest {

    @Test
    public void test() {
        assertThat(delNodes(TreeNode.of(1, 2, 3, 4, 5, 6, 7), new int[]{3, 5})).containsExactlyInAnyOrder(
                TreeNode.of(1, 2, null, 4),
                TreeNode.of(6),
                TreeNode.of(7)
        );
        assertThat(delNodes(TreeNode.of(1, 2, 4, null, 3), new int[]{3})).containsExactlyInAnyOrder(
                TreeNode.of(1, 2, 4)
        );
        assertThat(delNodes(TreeNode.of(1, 2, null, 4, 3), new int[]{2, 3})).containsExactlyInAnyOrder(
                TreeNode.of(1),
                TreeNode.of(4)
        );
        assertThat(delNodes(TreeNode.of(1, 2, 3, null, null, null, 4), new int[]{2, 1})).containsExactlyInAnyOrder(
                TreeNode.of(3, null, 4)
        );
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteTargets = new HashSet<>();
        for (int i : to_delete) {
            deleteTargets.add(i);
        }
        List<TreeNode> answer = new ArrayList<>();
        if (!deleteTargets.contains(root.val)) {
            answer.add(root);
        }
        deleteTargets(null, root, deleteTargets, answer);
        return answer;
    }

    private void deleteTargets(TreeNode parent, TreeNode node, Set<Integer> deleteTargets, List<TreeNode> answer) {
        if (node == null)
            return;
        if (deleteTargets.contains(node.val)) {
            if (node.left != null && !deleteTargets.contains(node.left.val)) {
                answer.add(node.left);
            }
            if (node.right != null && !deleteTargets.contains(node.right.val)) {
                answer.add(node.right);
            }
            if (parent != null && parent.right == node) {
                parent.right = null;
            }
            if (parent != null && parent.left == node) {
                parent.left = null;
            }
        }
        deleteTargets(node, node.left, deleteTargets, answer);
        deleteTargets(node, node.right, deleteTargets, answer);
    }

}
