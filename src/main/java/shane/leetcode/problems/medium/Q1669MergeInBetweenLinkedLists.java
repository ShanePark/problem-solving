package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1669MergeInBetweenLinkedLists {

    @Test
    public void test() {
        assertThat(mergeInBetween(ListNode.of(0, 1, 2, 3, 4, 5), 3, 4, ListNode.of(1000000, 1000001, 1000002))).isEqualTo((ListNode.of(0, 1, 2, 1000000, 1000001, 1000002, 5)));
        assertThat(mergeInBetween(ListNode.of(0, 1, 2, 3, 4, 5, 6), 2, 5, ListNode.of(1000000, 1000001, 1000002, 1000003, 1000004)))
                .isEqualTo(ListNode.of(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6));
        assertThat(mergeInBetween(ListNode.of(0, 3, 2, 1, 4, 5), 3, 4, ListNode.of(1000000, 1000001, 1000002))).isEqualTo((ListNode.of(0, 3, 2, 1000000, 1000001, 1000002, 5)));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;

        int index = 0;

        while (index++ < a - 1) {
            list1 = list1.next;
        }

        ListNode tail = list1.next;
        list1.next = list2;


        while (index++ < b) {
            tail = tail.next;
        }
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = tail.next;

        return dummy.next;
    }

}
