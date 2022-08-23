package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 11 ms, faster than 44.65% of Java online submissions for Palindrome Linked List.
 * Memory Usage: 57 MB, less than 93.21% of Java online submissions for Palindrome Linked List.
 */
public class Q234PalindromeLinkedList2 {

    @Test
    public void test() {
        assertThat(isPalindrome(ListNode.of(1, 2, 2, 1))).isEqualTo(true);
        assertThat(isPalindrome(ListNode.of(1, 2))).isEqualTo(false);
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        while (head != null) {
            dq.offerFirst(head.val);
            head = head.next;
        }

        while (dq.size() > 1) {
            if (!dq.pollFirst().equals(dq.pollLast())) {
                return false;
            }
        }
        return true;
    }
}
