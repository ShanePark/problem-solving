package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2471MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    @Test
    public void test() {
        assertThat(minimumOperations(TreeNode.of(1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10))).isEqualTo(3);
        assertThat(minimumOperations(TreeNode.of(1, 3, 2, 7, 6, 5, 4))).isEqualTo(3);
        assertThat(minimumOperations(TreeNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(0);
    }

    /**
     * 1 sec 602 ms
     */
    @Test
    public void tle() {
        int val = 100000;
        TreeNode root = TreeNode.of(100000);
        TreeNode node = root;
        Queue<TreeNode> q = new LinkedList<>();
        while (val > 4) {
            TreeNode poll = node;
            poll.left = new TreeNode(val - 1);
            poll.right = new TreeNode(val - 2);
            q.offer(poll.left);
            q.offer(poll.right);
            val -= 2;
            node = q.poll();
        }

        assertThat(minimumOperations(root)).isGreaterThan(0);
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                list.add(poll.val);
            }
            answer += operation(list);
        }
        return answer;
    }

    private int operation(List<Integer> list) {
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            int minIndex = i;
            int minVal = cur;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < minVal) {
                    minVal = list.get(j);
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                answer++;
                list.set(minIndex, cur);
            }
        }
        return answer;
    }

}
