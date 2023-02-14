package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 22 ms, faster than 26.98% of Java online submissions for Palindrome Linked List.
 * Memory Usage: 112.2 MB, less than 10.56% of Java online submissions for Palindrome Linked List.
 */
public class Q234PalindromeLinkedList {

    @Test
    public void test() {
        assertThat(isPalindrome(ListNode.of(1, 2, 2, 1))).isEqualTo(true);
        assertThat(isPalindrome(ListNode.of(1, 2))).isEqualTo(false);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        final int SIZE = list.size();
        for (int i = 0; i < SIZE / 2; i++) {
            if (list.get(i) != list.get(SIZE - 1 - i))
                return false;
        }
        return true;
    }
}
