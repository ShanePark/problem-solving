package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 18.00% of users with Java
 */
public class Q234PalindromeLinkedList3 {

    @Test
    public void test() {
        assertThat(isPalindrome(ListNode.of(1, 2, 2, 1))).isEqualTo(true);
        assertThat(isPalindrome(ListNode.of(1, 2))).isEqualTo(false);
        assertThat(isPalindrome(ListNode.of(1, 2, 1))).isEqualTo(true);
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.offerLast(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            int first = deque.pollFirst();
            if (deque.isEmpty()) {
                return true;
            }
            int last = deque.pollLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

}
