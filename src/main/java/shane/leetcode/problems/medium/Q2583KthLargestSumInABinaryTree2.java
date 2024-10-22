package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime49msBeats9.60%
 */
public class Q2583KthLargestSumInABinaryTree2 {

    @Test
    public void test() {
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7, 4, 6), 2)).isEqualTo(13);
        assertThat(kthLargestLevelSum(TreeNode.of(1, 2, null, 3), 1)).isEqualTo(3);
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7), 4)).isEqualTo(-1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> sums = new HashMap<>();
        traverse(root, sums, 0);
        if (sums.size() < k)
            return -1;
        Iterator<Long> it = sums.values().iterator();
        PriorityQueue<Long> pq = new PriorityQueue<>(k);
        while (it.hasNext()) {
            pq.offer(it.next());
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    private void traverse(TreeNode root, Map<Integer, Long> sums, int depth) {
        if (root == null)
            return;
        sums.merge(depth, (long) root.val, Long::sum);
        traverse(root.left, sums, depth + 1);
        traverse(root.right, sums, depth + 1);
    }

}
