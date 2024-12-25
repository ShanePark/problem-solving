package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats83.77%
 */
public class Q515FindLargestValueInEachTreeRow2 {

    @Test
    public void test() {
        assertThat(largestValues(TreeNode.of(1, 3, 2, 5, 3, null, 9))).containsExactly(1, 3, 9);
        assertThat(largestValues(TreeNode.of(1, 2, 3))).containsExactly(1, 3);
        assertThat(largestValues(null)).containsExactly();
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            answer.add(max);
        }
        return answer;
    }

}
