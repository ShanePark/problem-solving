package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 74.67%
 * Memory 41.9 MB Beats 55.81%
 */
public class Q863AllNodesDistanceKInBinaryTree {

    @Test
    void test() {
        assertThat(distanceK(
                TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4),
                TreeNode.of(5, 6, 2, null, null, 7, 4), 2)
        ).containsExactlyInAnyOrder(7, 4, 1);
        assertThat(distanceK(TreeNode.of(1), TreeNode.of(1), 3)).isEmpty();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeWrap> map = new HashMap<>();
        dfs(root, map, null);

        List<Integer> answer = new ArrayList<>();
        TreeWrap start = map.get(target.val);
        move(map, start, k, answer, new HashSet<>());
        return answer;
    }

    private void move(Map<Integer, TreeWrap> map, TreeWrap current, int distance, List<Integer> answer, Set<Integer> visited) {
        int currentVal = current.node.val;
        if (!visited.add(currentVal)) {
            return;
        }
        if (distance == 0) {
            answer.add(currentVal);
            return;
        }

        if (current.parent != null) {
            move(map, current.parent, distance - 1, answer, visited);
        }

        TreeNode left = current.node.left;
        if (left != null) {
            move(map, map.get(left.val), distance - 1, answer, visited);
        }
        TreeNode right = current.node.right;
        if (right != null) {
            move(map, map.get(right.val), distance - 1, answer, visited);
        }

        visited.remove(currentVal);
    }

    private void dfs(TreeNode node, Map<Integer, TreeWrap> map, TreeWrap parent) {
        if (node == null)
            return;
        TreeWrap nodeWrap = new TreeWrap(node, parent);
        map.put(node.val, nodeWrap);

        dfs(node.left, map, nodeWrap);
        dfs(node.right, map, nodeWrap);
    }

    class TreeWrap {
        TreeNode node;
        TreeWrap parent;

        public TreeWrap(TreeNode node, TreeWrap parent) {
            this.node = node;
            this.parent = parent;
        }
    }

}
