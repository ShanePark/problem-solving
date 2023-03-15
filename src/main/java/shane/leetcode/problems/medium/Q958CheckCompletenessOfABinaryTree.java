package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 10.97%
 * Memory 42.5 MB Beats 13.75%
 */
public class Q958CheckCompletenessOfABinaryTree {

    @Test
    public void test() {
        assertThat(isCompleteTree(TreeNode.of(1, 2, 3, 4, 5, 6))).isTrue();
        assertThat(isCompleteTree(TreeNode.of(1, 2, 3, 4, 5, null, 7))).isFalse();
        assertThat(isCompleteTree(TreeNode.of(1, 2, 3, 4, null, 6, 7))).isFalse();
        assertThat(isCompleteTree(TreeNode.of(1, 2, 3, null, null, 6))).isFalse();
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll == null)
                    return !q.stream().filter(n -> n != null).findAny().isPresent();
                q.offer(poll.left);
                q.offer(poll.right);
            }
        }
        return true;
    }

}
