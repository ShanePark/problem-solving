package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100.00% of users with Java
 */
public class Q1669MergeInBetweenLinkedLists2 {

    @Test
    public void test() {
        assertThat(mergeInBetween(ListNode.of(10, 1, 13, 6, 9, 5), 3, 4, ListNode.of(1000000, 1000001, 1000002))).isEqualTo(ListNode.of(10, 1, 13, 1000000, 1000001, 1000002, 5));
        assertThat(mergeInBetween(ListNode.of(0, 1, 2, 3, 4, 5, 6), 2, 5, ListNode.of(1000000, 1000001, 1000002, 1000003, 1000004))).isEqualTo(ListNode.of(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode cur = list1;
        while (index < a - 1) {
            cur = cur.next;
            index++;
        }

        ListNode modStart = cur;

        while (index < b) {
            cur = cur.next;
            index++;
        }

        ListNode cur2 = list2;
        while (cur2.next != null) {
            cur2 = cur2.next;
        }

        modStart.next = list2;
        cur2.next = cur.next;

        return list1;
    }

}
