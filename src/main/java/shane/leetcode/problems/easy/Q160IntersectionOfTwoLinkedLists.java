package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q160IntersectionOfTwoLinkedLists {

    @Test
    public void test() {
        ListNode listA = ListNode.of(4, 1);
        ListNode listB = ListNode.of(5, 6, 1);
        ListNode inter = ListNode.of(8, 4, 5);
        ListNode a = listA;
        ListNode b = listB;
        while (a.next != null) {
            a = a.next;
        }
        a.next = inter;

        while (b.next != null) {
            b = b.next;
        }
        b.next = inter;

        ListNode intersectionNode = getIntersectionNode(listA, listB);
        assertThat(intersectionNode).isEqualTo(inter);
    }

    @Test
    public void test2() {
        ListNode listA = ListNode.of(2, 6, 4);
        ListNode listB = ListNode.of(1, 5);
        ListNode intersectionNode = getIntersectionNode(listA, listB);
        assertThat(intersectionNode).isNull();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }

}
