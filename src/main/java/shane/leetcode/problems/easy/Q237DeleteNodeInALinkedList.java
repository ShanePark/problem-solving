package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q237DeleteNodeInALinkedList {

    @Test
    public void test() {
        ListNode node = ListNode.of(4, 5, 1, 9);
        deleteNode(node.next);
        assertThat(node).isEqualTo(ListNode.of(4, 1, 9));
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
