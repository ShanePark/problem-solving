package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime6msBeats31.54%
 */
public class Q2181MergeNodesInBetweenZeros {

    @Test
    public void test() {
        assertThat(mergeNodes(ListNode.of(0, 3, 1, 0, 4, 5, 2, 0))).isEqualTo(ListNode.of(4, 11));
        assertThat(mergeNodes(ListNode.of(0, 1, 0, 3, 0, 2, 2, 0))).isEqualTo(ListNode.of(1, 3, 4));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int sum = 0;
        while (head != null) {
            if (head.val == 0 && sum > 0) {
                cur.next = new ListNode(sum);
                sum = 0;
                cur = cur.next;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }

}
