package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q173BinarySearchTreeIterator {

    @Test
    public void test() {
        TreeNode tree = TreeNode.ofWithNull(7, 3, 15, null, null, 9, 20);
        BSTIterator b = new BSTIterator(tree);

        assertThat(b.next()).isEqualTo(3);
        assertThat(b.next()).isEqualTo(7);
        assertThat(b.hasNext()).isTrue();
        assertThat(b.next()).isEqualTo(9);
        assertThat(b.hasNext()).isTrue();
        assertThat(b.next()).isEqualTo(15);
        assertThat(b.hasNext()).isTrue();
        assertThat(b.next()).isEqualTo(20);
        assertThat(b.hasNext()).isFalse();
    }

    class BSTIterator {

        Queue<Integer> q = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            traverse(root);
        }

        private void traverse(TreeNode root) {
            if (root == null)
                return;
            traverse(root.left);
            q.offer(root.val);
            traverse(root.right);
        }

        public int next() {
            return q.poll();
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
