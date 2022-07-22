package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q86PartitionList {

    @Test
    public void test() {
        ListNode node = ListNode.of(1, 4, 3, 2, 5, 2);
        ListNode partition = partition(node, 3);
        assertThat(partition).isEqualTo(ListNode.of(1, 2, 2, 4, 3, 5));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(2, 1);
        ListNode partition = partition(node, 2);
        assertThat(partition).isEqualTo(ListNode.of(1, 2));
    }

    @Test
    public void test3() {
        ListNode node = ListNode.of(3, 4, 5);
        ListNode partition = partition(node, 2);
        assertThat(partition).isEqualTo(ListNode.of(3, 4, 5));
    }


    @Test
    public void test4() {
        ListNode node = ListNode.of(3, 4, 5);
        ListNode partition = partition(node, 7);
        assertThat(partition).isEqualTo(ListNode.of(3, 4, 5));
    }

    @Test
    public void test5() {
        ListNode partition = partition(null, 7);
        assertThat(partition).isEqualTo(null);
    }


    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode();
        ListNode goe = new ListNode();
        ListNode smallerTail = smaller;
        ListNode goeTail = goe;

        while (head != null) {
            if (head.val < x) {
                smallerTail.next = head;
                smallerTail = smallerTail.next;
            } else {
                goeTail.next = head;
                goeTail = goeTail.next;
            }
            head = head.next;
        }

        smallerTail.next = goe.next;
        goeTail.next = null;

        return smaller.next;
    }
}
