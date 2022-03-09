package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q82RemoveDuplicatesFromSortedListII {

    @Test
    void test() {
        ListNode head = deleteDuplicates(ListNode.of(new int[]{1, 2, 3, 3, 4, 4, 5}));
        head.print();

        int[] answer = {1, 2, 5};
        int i = 0;
        while (head != null) {
            assertThat(head.val).isEqualTo(answer[i++]);
            head = head.next;
        }
        assertThat(i).isEqualTo(answer.length);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        int[] arr = new int[201];
        while (head != null) {
            arr[head.val + 100]++;
            head = head.next;
        }

        for (int i = 0; i < 201; i++) {
            if (arr[i] == 1) {
                node.next = new ListNode(i - 100);
                node = node.next;
            }
        }

        return dummy.next;
    }
}
