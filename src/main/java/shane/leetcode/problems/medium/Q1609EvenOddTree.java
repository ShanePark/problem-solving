package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 38.87% of users with Java
 */
public class Q1609EvenOddTree {

    @Test
    public void test() {
        assertThat(isEvenOddTree(TreeNode.of(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2))).isTrue();
        assertThat(isEvenOddTree(TreeNode.of(5, 4, 2, 3, 3, 7))).isFalse();
        assertThat(isEvenOddTree(TreeNode.of(5, 9, 1, 3, 5, 7))).isFalse();
    }

    @Test
    public void test2() {
        Status even = Status.EVEN;
        assertThat(even.isValid(12, 8)).isTrue();
    }

    public boolean isEvenOddTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return isEvenOddTree(root, 1, list);
    }

    private boolean isEvenOddTree(TreeNode node, int depth, List<Integer> list) {
        if (node == null)
            return true;
        int cur = node.val;
        if (list.size() == depth) {
            list.add(null);
        }
        Status status = Status.get(depth);
        if (!status.isValid(cur)) {
            return false;
        }
        Integer before = list.get(depth);
        if (!status.isValid(before, cur)) {
            return false;
        }
        list.set(depth, cur);
        if (!isEvenOddTree(node.left, depth + 1, list)) {
            return false;
        }
        return isEvenOddTree(node.right, depth + 1, list);
    }

    enum Status {
        ODD(Comparator.naturalOrder()), EVEN(Comparator.reverseOrder());

        Status(Comparator<Integer> tComparator) {
            this.comparator = tComparator;
        }

        private final Comparator<Integer> comparator;

        public boolean isValid(Integer before, int after) {
            if (before == null)
                return true;
            return comparator.compare(before, after) < 0;
        }

        public boolean isValid(int n) {
            int mod = n % 2;
            if (this == ODD) {
                return mod == 1;
            }
            return mod == 0;
        }

        static Status get(int n) {
            if (n % 2 == 1)
                return ODD;
            return EVEN;
        }
    }

}
