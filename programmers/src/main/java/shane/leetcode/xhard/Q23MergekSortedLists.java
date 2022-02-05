package shane.leetcode.xhard;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q23MergekSortedLists {

    @Test
    void test() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode node = mergeKLists(lists);
        printNode(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue();
        for (ListNode list : lists) {
            while (list != null) {
                q.offer(list.val);
                list = list.next;
            }
        }

        ListNode root = new ListNode();
        ListNode cur = root;

        while (!q.isEmpty()) {
            cur.next = new ListNode(q.poll());
            cur = cur.next;
        }
        return root.next;
    }

    private void printNode(ListNode node) {
        while (node != null) {
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }

    public class ListNode {
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
    }


}
