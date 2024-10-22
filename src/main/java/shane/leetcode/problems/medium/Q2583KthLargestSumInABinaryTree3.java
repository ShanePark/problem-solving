package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime32msBeats65.40%
 */
public class Q2583KthLargestSumInABinaryTree3 {

    @Test
    public void test() {
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7, 4, 6), 2)).isEqualTo(13);
        assertThat(kthLargestLevelSum(TreeNode.of(1, 2, null, 3), 1)).isEqualTo(3);
        assertThat(kthLargestLevelSum(TreeNode.of(5, 8, 9, 2, 1, 3, 7), 4)).isEqualTo(-1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                sum += poll.val;
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            pq.offer(sum);
            if (pq.size() > k)
                pq.poll();
        }

        if (pq.size() < k)
            return -1;
        return pq.peek();
    }

}
