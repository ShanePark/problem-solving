package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 126ms Beats 30.79%of users with Java
 * Memory Details 95.55MB Beats 30.04%of users with Java
 */
public class Q2385AmountOfTimeForBinaryTreeToBeInfected {

    @Test
    public void test() {
        assertThat(amountOfTime(TreeNode.of(1, 5, 3, null, 4, 10, 6, 9, 2), 3)).isEqualTo(4);
        assertThat(amountOfTime(TreeNode.of(1), 1)).isEqualTo(0);
        assertThat(amountOfTime(TreeNode.of(2, 5), 5)).isEqualTo(1);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> selfMap = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        traverse(root, selfMap, parentMap, null);

        Set<Integer> infected = new HashSet<>();
        int time = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(selfMap.get(start));
        infected.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null)
                    continue;
                TreeNode parent = parentMap.get(node);
                testAndAddToQueue(parent, infected, q);
                testAndAddToQueue(node.left, infected, q);
                testAndAddToQueue(node.right, infected, q);
            }
            time++;
        }
        return time;
    }

    private void testAndAddToQueue(TreeNode node, Set<Integer> infected, Queue<TreeNode> q) {
        if (node != null && infected.add(node.val)) {
            q.offer(node);
        }
    }

    private void traverse(TreeNode node, Map<Integer, TreeNode> selfMap, Map<TreeNode, TreeNode> parentMap, TreeNode parent) {
        if (node == null)
            return;
        selfMap.put(node.val, node);
        parentMap.put(node, parent);
        traverse(node.left, selfMap, parentMap, node);
        traverse(node.right, selfMap, parentMap, node);
    }

}
