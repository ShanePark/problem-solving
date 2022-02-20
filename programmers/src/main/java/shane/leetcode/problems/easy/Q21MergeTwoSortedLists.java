package shane.leetcode.problems.easy;

public class Q21MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(list1, list2);
        printNode(result);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    tail.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    tail.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }

            tail = tail.next;
        }

        return head.next;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void printNode() {
            ListNode head = this;
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
    }

    private static void printNode(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
