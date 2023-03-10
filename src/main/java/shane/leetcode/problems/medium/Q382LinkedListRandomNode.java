package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Runtime 13 ms Beats 35.62%
 * Memory 43.5 MB Beats 89.20%
 */
public class Q382LinkedListRandomNode {

    @Test
    public void test() {
        Solution solution = new Solution(ListNode.of(1, 2, 3));
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int random = solution.getRandom();
            counter.merge(random, 1, Integer::sum);
        }
        Assertions.assertThat(counter.size()).isEqualTo(3);
        System.out.println("counter = " + counter);
    }

    class Solution {

        List<Integer> list = new ArrayList<>();

        public Solution(ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
