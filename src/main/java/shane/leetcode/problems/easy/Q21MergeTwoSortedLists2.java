package shane.leetcode.problems.easy;


import com.tistory.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;

@SuppressWarnings("DuplicatedCode")
public class Q21MergeTwoSortedLists2 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode tail = list1;

        tail = add(tail, 2);
        tail = add(tail, 4);

        ListNode list2 = new ListNode(1);
        tail = list2;

        tail = add(tail, 3);
        tail = add(tail, 4);

        ListNode result = mergeTwoLists(list1, list2);
        int[] answer = new int[]{1, 1, 2, 3, 4, 4};
        for (int i = 0; i < answer.length; i++) {
            Assertions.assertThat(result.val).isEqualTo(answer[i]);
            result = result.next;
        }
    }

    public static ListNode add(ListNode node, int n) {
        node.next = new ListNode(n);
        return node.next;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }

}
