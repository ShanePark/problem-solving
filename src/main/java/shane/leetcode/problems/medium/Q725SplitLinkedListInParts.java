package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 43.76MB Beats 38.88%of users with Java
 */
public class Q725SplitLinkedListInParts {

    @Test
    public void TEST() {
        assertThat(splitListToParts(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)).isEqualTo(new ListNode[]{ListNode.of(1, 2, 3, 4), ListNode.of(5, 6, 7), ListNode.of(8, 9, 10)});
        assertThat(splitListToParts(ListNode.of(1, 2, 3), 5)).isEqualTo(new ListNode[]{ListNode.of(1), ListNode.of(2), ListNode.of(3), null, null});
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];

        int size = getSize(head);
        for (int i = 0; i < k; i++) {
            int length = (size / k) + (i < (size % k) ? 1 : 0);
            answer[i] = head;
            for (int j = 0; j < length - 1; j++) {
                head = head.next;
            }
            ListNode last = head;
            if (head != null) {
                head = head.next;
                last.next = null;
            }
        }

        return answer;
    }

    private static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

}
